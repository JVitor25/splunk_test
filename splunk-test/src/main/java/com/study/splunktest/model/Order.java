package com.study.splunktest.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
	
	private int id;
	private String name;
	private int quantity;
	private double price;
	private String transactionId;
	private Date orderPlacedDate;
}
