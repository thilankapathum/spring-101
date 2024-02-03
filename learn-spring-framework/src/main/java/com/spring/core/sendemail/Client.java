package com.spring.core.sendemail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {

        /*EmailService emailService = new EmailService();
        emailService.sendEmail();*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService emailService = applicationContext.getBean(EmailService.class);
        emailService.sendEmail();
    }
}
