package com.juan.EmailService.core;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
