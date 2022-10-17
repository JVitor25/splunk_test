package com.study.splunktest.controller;

import com.study.splunktest.model.Order;
import com.study.splunktest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrder(){
        List<Order> orders = orderService.getOrders();
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id){
        Order order = orderService.getOrder(id);
        return order;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        Order addOrder = orderService.addOrder(order);
        return addOrder;
    }
}
