package com.study.splunktest.controller;

import com.study.splunktest.model.Order;
import com.study.splunktest.service.OrderService;
import com.study.splunktest.utility.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders(){
        List<Order> orders = orderService.getOrders();
        logger.info("OrderController:placeOrder response from service {}", Mapper.mapToJsonString(orders));
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id){
        logger.info("OrderController:getOrder fetch order by id '{}'", id);
        Order order = orderService.getOrder(id);
        logger.info("OrderController:placeOrder fetch order response {}", Mapper.mapToJsonString(order));
        return order;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        logger.info("OrderController:placeOrder persist order request {}", Mapper.mapToJsonString(order));
        Order addOrder = orderService.addOrder(order);
        logger.info("OrderController:placeOrder response from service {}", Mapper.mapToJsonString(addOrder));
        return addOrder;
    }
}
