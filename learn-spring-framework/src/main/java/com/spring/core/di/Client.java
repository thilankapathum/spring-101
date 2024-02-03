package com.spring.core.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

    public static void main(String[] args) {

        String message = "Hi, Good Morning";

        /*  -- Dependency Injection without Spring.
        SMSService smsService = new SMSService();
        EmailService emailService = new EmailService();

        MessageSender messageSender = new MessageSender(emailService);
        messageSender.sendMessage(message);
        */

        // -- Dependency Injection with using Spring.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);    // -- Application Context interface acts as a SIOC-Container.
                                                                                                            // -- AppConfig.class specifies the configuration necessary for SIOCC.

        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage(message);

    }
}
