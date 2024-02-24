package dev.thilanka.springboot.service;

import dev.thilanka.springboot.dto.OrderRequest;
import dev.thilanka.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
