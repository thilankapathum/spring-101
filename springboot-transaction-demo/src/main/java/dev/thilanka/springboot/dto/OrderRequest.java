package dev.thilanka.springboot.dto;

import dev.thilanka.springboot.entity.Order;
import dev.thilanka.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
