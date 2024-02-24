package dev.thilanka.springboot.exception;

import dev.thilanka.springboot.repository.PaymentRepository;

public class PaymentException extends RuntimeException{
    public PaymentException(String message){
        super(message);
    }
}
