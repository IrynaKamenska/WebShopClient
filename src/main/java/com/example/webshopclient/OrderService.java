package com.example.webshopclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    private WebClient client = WebClient.create("https://my-json-server.typicode.com/Flooooooooooorian/OrderApi");

    public List<Order> getOrders (){
        return client.get()
                .uri("/orders")
                .retrieve()
                .toEntityList(Order.class)
                .block()
                .getBody();
    }


    public Order addOrder(String id) {
        List<Order> orderList = getOrders();
        for (Order order : orderList){
            if(order.id().equals(id)){
                orderRepo.addOrder(order);
                return order;
            }
        } throw new IllegalArgumentException("No order with id " + id + " was found");

    }


  /*  public Order addOrder(String id) {
        List<Order> orderList = client.get()
                .uri("/orders")
                .retrieve()
                .toEntityList(Order.class)
                .block()
                .getBody();
        for (Order order : orderList){
            if(order.id().equals(id)){
                orderRepo.addOrder(order);
                System.out.println(order);
                return order;
            }
        } throw new IllegalArgumentException("No order with id " + id + " was found");

    }
*/
}
