package com.example.webshopclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
@Data
@AllArgsConstructor
public class OrderRepo {
    private final List<Order> orders = new ArrayList<>();

    public Order addOrder(Order order) {
         orders.add(order);
        return order;
    }

}
