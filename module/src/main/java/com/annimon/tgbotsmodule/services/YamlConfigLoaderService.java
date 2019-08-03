package com.annimon.tgbotsmodule.services;

import com.annimon.tgbotsmodule.exceptions.ConfigLoaderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class YamlConfigLoaderService<T> implements ConfigLoaderService<T> {

    private static final Logger log = LogManager.getLogger(YamlConfigLoaderService.class);

    @NotNull
    @Override
    public File configFile(@NotNull String baseName, @NotNull String profile) {
        final Predicate<File> validFile = f -> f.exists() && f.canRead();
        File file;
        if (!profile.isEmpty()) {
            file = new File(baseName + "-" + profile + ".yaml");
            if (validFile.test(file)) {
                return file;
            }
        }
        file = new File(baseName + ".yaml");
        if (validFile.test(file)) {
            return file;
        }
        throw new ConfigLoaderException("No " + baseName + ".yaml file");
    }

    @Override
    public @NotNull T load(@NotNull File file, @NotNull Class<T> configType,
                           boolean validate, Consumer<ObjectMapper> mapperConsumer) {
        final var mapper = new ObjectMapper(new YamlConfigFactory());
        if (mapperConsumer != null) {
            mapperConsumer.accept(mapper);
        }
        try {
            var config = mapper.readValue(file, configType);
            if (validate) {
                validate(config);
            }
            return config;
        } catch (IOException ex) {
            log.error(ex);
            throw new ConfigLoaderException(ex);
        }
    }

    private void validate(T config) {
        final var factory = Validation.buildDefaultValidatorFactory();
        final var violations = factory.getValidator().validate(config);
        if (!violations.isEmpty()) {
            String description = violations.stream()
                    .map(cv -> String.format("Config property %s %s", cv.getPropertyPath(), cv.getMessage()))
                    .collect(Collectors.joining("\n"));
            throw new ConfigLoaderException(description);
        }
    }
}