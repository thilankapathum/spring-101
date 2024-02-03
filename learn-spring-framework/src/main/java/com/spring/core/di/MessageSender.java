package com.spring.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    /* --Tight coupling

    private SMSService smsService;
    private EmailService emailService;

    public MessageSender(EmailService emailService){
        this.smsService = smsService;
    }
    */

    private MessageService messageService;
    private MessageService smsService;

    //@Autowired  // -- Used to tell SIOCC to automatically inject Beans.
    public MessageSender(@Qualifier("emailService") MessageService messageService){

        this.messageService = messageService;
        System.out.println("Constructor based DI");
    }

    @Autowired
    public MessageSender(@Qualifier("emailService") MessageService messageService, @Qualifier("smsService") MessageService smsService){

        this.messageService = messageService;
        this.smsService = smsService;
        System.out.println("Constructor based DI 2");
    }

    public void sendMessage(String message){

        this.messageService.sendMessage("Message Service: " + message);
        this.smsService.sendMessage("SMS Service" + message);
    }
}
