package com.study.splunktest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import com.study.splunktest.model.Order;
	
@Service
public class OrderService {

	private List<Order> orderList = new ArrayList<>();

	public List<Order> getOrders(){
		List<Order> list = null;
		list = orderList;
		return list;
	}

	public Order getOrder(int id){
		Order order = orderList.stream()
				.filter(ord -> ord.getId() == id)
				.findAny().orElseThrow(() -> new RuntimeException("Order not found with id : " + id));
		return order;
	}

	public Order addOrder(Order order) {
		order.setOrderPlacedDate(new Date());
		order.setTransactionId(UUID.randomUUID().toString());
		orderList.add(order);
		return order;
	}
}
