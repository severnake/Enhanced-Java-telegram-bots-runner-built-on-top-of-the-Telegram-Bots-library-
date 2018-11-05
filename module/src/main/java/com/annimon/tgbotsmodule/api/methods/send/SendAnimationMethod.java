package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.MediaMessageMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ParseModeMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.CaptionMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.DurationMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.ThumbMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.io.InputStream;
import java.util.Objects;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendAnimationMethod implements
        MediaMessageMethod<SendAnimationMethod, Message>,
        ParseModeMethod<SendAnimationMethod, Message>,
        CaptionMethod<SendAnimationMethod, Message>,
        DurationMethod<SendAnimationMethod, Message>,
        ThumbMethod<SendAnimationMethod, Message> {

    private final SendAnimation method;

    public SendAnimationMethod() {
        this(new SendAnimation());
    }

    public SendAnimationMethod(@NotNull SendAnimation method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return method.getChatId();
    }

    @Override
    public SendAnimationMethod setChatId(@NotNull String chatId) {
        method.setChatId(chatId);
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendAnimationMethod setReplyToMessageId(Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return !Objects.requireNonNullElse(method.getDisableNotification(), false);
    }

    @Override
    public SendAnimationMethod enableNotification() {
        method.enableNotification();
        return this;
    }

    @Override
    public SendAnimationMethod disableNotification() {
        method.disableNotification();
        return this;
    }

    @Override
    public ReplyKeyboard getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendAnimationMethod setReplyMarkup(ReplyKeyboard replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    @Override
    public InputFile getFile() {
        return method.getAnimation();
    }

    @Override
    public SendAnimationMethod setFile(@NotNull String fileId) {
        method.setAnimation(fileId);
        return this;
    }

    @Override
    public SendAnimationMethod setFile(@NotNull java.io.File file) {
        method.setAnimation(file);
        return this;
    }

    @Override
    public SendAnimationMethod setFile(@NotNull String name, @NotNull InputStream inputStream) {
        method.setAnimation(name, inputStream);
        return this;
    }

    @Override
    public SendAnimationMethod setFile(@NotNull InputFile file) {
        method.setAnimation(file);
        return this;
    }

    @Override
    public String getParseMode() {
        return method.getParseMode();
    }

    @Override
    public SendAnimationMethod setParseMode(String parseMode) {
        method.setParseMode(parseMode);
        return this;
    }
    
    @Override
    public String getCaption() {
        return method.getCaption();
    }

    @Override
    public SendAnimationMethod setCaption(String caption) {
        method.setCaption(caption);
        return this;
    }

    @Override
    public Integer getDuration() {
        return method.getDuration();
    }

    @Override
    public SendAnimationMethod setDuration(Integer duration) {
        method.setDuration(duration);
        return this;
    }

    @Override
    public InputFile getThumb() {
        return method.getThumb();
    }

    @Override
    public SendAnimationMethod setThumb(InputFile thumb) {
        method.setThumb(thumb);
        return this;
    }

    public Integer getWidth() {
        return method.getWidth();
    }

    public SendAnimationMethod setWidth(Integer width) {
        method.setWidth(width);
        return this;
    }

    public Integer getHeight() {
        return method.getHeight();
    }

    public SendAnimationMethod setHeight(Integer height) {
        method.setHeight(height);
        return this;
    }

    @Override
    public Message execute(@NotNull CommonAbsSender sender) {
        return sender.call(method);
    }

    @Override
    public void executeAsync(@NotNull CommonAbsSender sender,
                             @Nullable Consumer<? super Message> responseConsumer,
                             @Nullable Consumer<TelegramApiException> apiExceptionConsumer,
                             @Nullable Consumer<Exception> exceptionConsumer) {
        sender.callAsync(method, responseConsumer, apiExceptionConsumer);
    }
}