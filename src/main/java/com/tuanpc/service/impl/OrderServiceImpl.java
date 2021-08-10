package com.tuanpc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuanpc.dao.OrderDAO;
import com.tuanpc.dao.OrderDetailDAO;
import com.tuanpc.entity.Order;
import com.tuanpc.entity.OrderDetail;
import com.tuanpc.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired OrderDAO orderdao;
	@Autowired OrderDetailDAO orderDetaildao;
	
	@Override
	public Order create(JsonNode orderData) {
ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		orderdao.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
					.stream()
					.peek(d -> d.setOrder(order)).collect(Collectors.toList());
		orderDetaildao.saveAll(details);
		return order;
	}

	@Override
	public Order findById(Long id) {
		return orderdao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return orderdao.findByUsername(username);
	}

	@Override
	public List<Order> findAll() {
		return orderdao.findAll();
	}

	@Override
	public Order create(Order product) {
		return orderdao.save(product);
	}

	@Override
	public Order update(Order product) {
		return orderdao.save(product);
	}

	@Override
	public void delete(Long id) {
		orderdao.deleteById(id);
		
	}
}
