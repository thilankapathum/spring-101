package com.spring.core.di;

import org.springframework.stereotype.Component;

@Component("smsService")  // -- SIOCC will create a Spring Bean for this class.
public class SMSService implements MessageService {

    @Override
    public void sendMessage(String message){
        System.out.println(message);
    }
}
