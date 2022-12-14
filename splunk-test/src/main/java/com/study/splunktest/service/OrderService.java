package com.study.splunktest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.study.splunktest.utility.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import com.study.splunktest.model.Order;
	
@Service
public class OrderService {

	Logger logger = LogManager.getLogger(OrderService.class);

	private List<Order> orderList = new ArrayList<>();

	public List<Order> getOrders(){
		logger.info("OrderService:getOrders execution started...");
		List<Order> list = null;
		list = orderList;
		logger.info("OrderService:addOrder response {}", Mapper.mapToJsonString(orderList));
		logger.info("OrderService:getOrders execution ended...");
		return list;
	}

	public Order getOrder(int id){
		logger.info("OrderService:getOrder execution started...");
		Order order = orderList.stream()
				.filter(ord -> ord.getId() == id)
				.findAny().orElseThrow(() -> new RuntimeException("Order not found with id : " + id));
		logger.info("OrderService:getOrder execution ended...");
		return order;
	}

	public Order addOrder(Order order) {
		logger.info("OrderService:addOrder execution started...");
		logger.info("OrderService:addOrder request payload {}", Mapper.mapToJsonString(order));
		order.setOrderPlacedDate(new Date());
		order.setTransactionId(UUID.randomUUID().toString());
		orderList.add(order);
		logger.info("OrderService:addOrder execution ended...");
		return order;
	}
}
