package com.example.notificationservice.dto;

public class NotificationRequest {
    private String senderEmail;
    private String senderPassword;
    private String recipientEmail;
    private String subject;
    private String message;

    public NotificationRequest() {}

    public NotificationRequest(String senderEmail,String senderPassword,String recipientEmail, String subject, String message) {
    	this.senderEmail=senderEmail;
    	this.senderPassword=senderPassword;
    	this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.message = message;
        
    }

    // Getters and Setters
    public String getRecipient() { return recipientEmail; }
    public void setRecipient(String recipient) { this.recipientEmail = recipient; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSenderPassword() {
		return senderPassword;
	}

	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
}