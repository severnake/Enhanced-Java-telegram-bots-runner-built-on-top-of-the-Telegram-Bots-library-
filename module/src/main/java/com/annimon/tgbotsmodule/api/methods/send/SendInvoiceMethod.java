package com.annimon.tgbotsmodule.api.methods.send;

import com.annimon.tgbotsmodule.api.methods.interfaces.InlineKeyboardMarkupMethod;
import com.annimon.tgbotsmodule.api.methods.interfaces.SendableMessageMethod;
import com.annimon.tgbotsmodule.services.CommonAbsSender;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendInvoiceMethod implements
        SendableMessageMethod<SendInvoiceMethod, Message>,
        InlineKeyboardMarkupMethod<SendInvoiceMethod, Message> {

    private final SendInvoice method;

    public SendInvoiceMethod() {
        this(new SendInvoice());
    }

    public SendInvoiceMethod(@NotNull SendInvoice method) {
        this.method = method;
    }

    @Override
    public String getChatId() {
        return Integer.toString(method.getChatId());
    }

    @Override
    public SendInvoiceMethod setChatId(long chatId) {
        method.setChatId((int) chatId);
        return this;
    }

    @Override
    public SendInvoiceMethod setChatId(@NotNull String chatId) {
        method.setChatId(Integer.parseInt(chatId, 10));
        return this;
    }

    @Override
    public Integer getReplyToMessageId() {
        return method.getReplyToMessageId();
    }

    @Override
    public SendInvoiceMethod setReplyToMessageId(@NotNull Integer messageId) {
        method.setReplyToMessageId(messageId);
        return this;
    }

    @Override
    public boolean isNotificationDisabled() {
        return !Objects.requireNonNullElse(method.getDisableNotification(), false);
    }

    @Override
    public SendInvoiceMethod enableNotification() {
        method.setDisableNotification(false);
        return this;
    }

    @Override
    public SendInvoiceMethod disableNotification() {
        method.setDisableNotification(true);
        return this;
    }

    @Override
    public SendInvoiceMethod setNotificationEnabled(boolean status) {
        method.setDisableNotification(!status);
        return this;
    }

    @Override
    public InlineKeyboardMarkup getReplyMarkup() {
        return method.getReplyMarkup();
    }

    @Override
    public SendInvoiceMethod setReplyMarkup(@NotNull InlineKeyboardMarkup replyMarkup) {
        method.setReplyMarkup(replyMarkup);
        return this;
    }

    public String getTitle() {
        return method.getTitle();
    }

    public SendInvoiceMethod setTitle(String title) {
        method.setTitle(title);
        return this;
    }

    public String getDescription() {
        return method.getDescription();
    }

    public SendInvoiceMethod setDescription(String description) {
        method.setDescription(description);
        return this;
    }

    public String getPayload() {
        return method.getPayload();
    }

    public SendInvoiceMethod setPayload(String payload) {
        method.setPayload(payload);
        return this;
    }

    public String getProviderToken() {
        return method.getProviderToken();
    }

    public SendInvoiceMethod setProviderToken(String providerToken) {
        method.setProviderToken(providerToken);
        return this;
    }

    public String getStartParameter() {
        return method.getStartParameter();
    }

    public SendInvoiceMethod setStartParameter(String startParameter) {
        method.setStartParameter(startParameter);
        return this;
    }

    public String getCurrency() {
        return method.getCurrency();
    }

    public SendInvoiceMethod setCurrency(String currency) {
        method.setCurrency(currency);
        return this;
    }

    public List<LabeledPrice> getPrices() {
        return method.getPrices();
    }

    public SendInvoiceMethod setPrices(List<LabeledPrice> prices) {
        method.setPrices(prices);
        return this;
    }

    public String getPhotoUrl() {
        return method.getPhotoUrl();
    }

    public SendInvoiceMethod setPhotoUrl(String photoUrl) {
        method.setPhotoUrl(photoUrl);
        return this;
    }

    public Integer getPhotoSize() {
        return method.getPhotoSize();
    }

    public SendInvoiceMethod setPhotoSize(Integer photoSize) {
        method.setPhotoSize(photoSize);
        return this;
    }

    public Integer getPhotoWidth() {
        return method.getPhotoWidth();
    }

    public SendInvoiceMethod setPhotoWidth(Integer photoWidth) {
        method.setPhotoWidth(photoWidth);
        return this;
    }

    public Integer getPhotoHeight() {
        return method.getPhotoHeight();
    }

    public SendInvoiceMethod setPhotoHeight(Integer photoHeight) {
        method.setPhotoHeight(photoHeight);
        return this;
    }

    public Boolean getNeedName() {
        return method.getNeedName();
    }

    public SendInvoiceMethod setNeedName(Boolean needName) {
        method.setNeedName(needName);
        return this;
    }

    public Boolean getNeedPhoneNumber() {
        return method.getNeedPhoneNumber();
    }

    public SendInvoiceMethod setNeedPhoneNumber(Boolean needPhoneNumber) {
        method.setNeedPhoneNumber(needPhoneNumber);
        return this;
    }

    public Boolean getNeedEmail() {
        return method.getNeedEmail();
    }

    public SendInvoiceMethod setNeedEmail(Boolean needEmail) {
        method.setNeedEmail(needEmail);
        return this;
    }

    public Boolean getNeedShippingAddress() {
        return method.getNeedShippingAddress();
    }

    public SendInvoiceMethod setNeedShippingAddress(Boolean needShippingAddress) {
        method.setNeedShippingAddress(needShippingAddress);
        return this;
    }

    public Boolean getFlexible() {
        return method.getFlexible();
    }

    public SendInvoiceMethod setFlexible(Boolean flexible) {
        method.setFlexible(flexible);
        return this;
    }

    public String getProviderData() {
        return method.getProviderData();
    }

    public SendInvoiceMethod setProviderData(String providerData) {
        method.setProviderData(providerData);
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
        sender.callAsync(method, responseConsumer, apiExceptionConsumer, exceptionConsumer);
    }
}