package com.spring.core.di;

import org.springframework.stereotype.Component;

@Component("emailService")  // -- Spring IoC Containter will create a Spring Bean for this class.
public class EmailService implements MessageService{

    @Override
    public void sendMessage(String message){
        System.out.println(message);
    }
}
