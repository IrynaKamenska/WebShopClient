package com.example.webshopclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    public final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping(path = "{id}")
    public Order addOrder(@PathVariable String id) {
        return orderService.addOrder(id);
    }


}
