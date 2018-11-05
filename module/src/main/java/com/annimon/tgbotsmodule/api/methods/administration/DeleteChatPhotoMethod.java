package com.annimon.tgbotsmodule.api.methods.administration;

import com.annimon.tgbotsmodule.api.methods.interfaces.ChatMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.groupadministration.DeleteChatPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeleteChatPhotoMethod implements ChatMethod<DeleteChatPhotoMethod, Boolean> {

    private final DeleteChatPhoto method;

    public DeleteChatPhotoMethod() {
        this(new DeleteChatPhoto());
    }

    public DeleteChatPhotoMethod(@NotNull DeleteChatPhoto method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public DeleteChatPhotoMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Boolean execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Boolean> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}
