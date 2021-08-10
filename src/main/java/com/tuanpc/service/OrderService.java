package com.tuanpc.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.tuanpc.entity.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);
	
	List<Order> findAll();

	Order create(Order product);

	Order update(Order product);

	void delete(Long id);

}
