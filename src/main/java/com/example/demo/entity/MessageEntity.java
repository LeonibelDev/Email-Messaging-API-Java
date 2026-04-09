package com.example.demo.entity;

public class MessageEntity {

    private String recipient;
    private String subject;
    private String body;
    private String url;
    private String buttonText;
    private String imageUrl;

    public MessageEntity() {}

    public MessageEntity(
        String recipient,
        String subject,
        String body,
        String url,
        String buttonText,
        String imageUrl
    ) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.url = url;
        this.buttonText = buttonText;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getUrl() {
        return url;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    // Setters
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
