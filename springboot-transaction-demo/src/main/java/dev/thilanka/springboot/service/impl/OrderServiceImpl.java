package dev.thilanka.springboot.service.impl;

import dev.thilanka.springboot.dto.OrderRequest;
import dev.thilanka.springboot.dto.OrderResponse;
import dev.thilanka.springboot.entity.Order;
import dev.thilanka.springboot.entity.Payment;
import dev.thilanka.springboot.exception.PaymentException;
import dev.thilanka.springboot.repository.OrderRepository;
import dev.thilanka.springboot.repository.PaymentRepository;
import dev.thilanka.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service    //-- Define Service Class
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }



    @Override
    @Transactional  //-- Use Transaction to handle multiple operations (Eg: save(order) and save(payment)). Has multiple implementations
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        //-- Saving Order to orders Table
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        //-- Saving Payment to payment Table
        Payment payment = orderRequest.getPayment();
        payment.setOrderId(order.getId());

        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Card Type Not Supported");
        }
        paymentRepository.save(payment);

        //-- Creating OrderResponse to be returned
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
