package com.juan.EmailService.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
