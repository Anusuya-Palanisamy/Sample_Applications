package com.OMS.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OMS.Request.OrderRequest;
import com.OMS.model.Address;
import com.OMS.model.Orders;
import com.OMS.model.Product;
import com.OMS.repository.OrderRepository;

import reactor.core.publisher.Mono;


@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	public  Orders saveOrUpdateOrder(OrderRequest orderRequest) {
		Orders orderData = new Orders();
		List<Product> lp = new ArrayList<Product>();
		Product product = orderRequest.getProduct();
		Product productNew = new Product();
		productNew.setProductName(product.getProductName());
		productNew.setDescription(product.getDescription());
		productNew.setPrice(product.getPrice());

		Address addressData = orderRequest.getAddress();
		Address address = new Address();
		address.setAddressDetails(addressData.getAddressDetails());
		address.setAddressid(addressData.getAddressid());
		address.setCity(addressData.getCity());
		address.setPincode(addressData.getPincode());
		address.setState(addressData.getState());
		productNew.setAddress(address);
		lp.add(productNew);
		orderData.setProduct(lp);
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		   LocalDateTime now = LocalDateTime.now();
		   String dateFormat=dtf.format(now);
		   orderData.setDate(dateFormat);
		orderData.setCustomerId(orderRequest.getCustomerId());

		return orderRepository.save(orderData);

	}

	public List<Orders> getOderList(String customerId) {
		System.out.println("Entered to Order Service");
		List<Orders> order = orderRepository.findOrdersByCustomerId(customerId);
		System.out.println(order);
		return order;
	}

	public List<Orders> findAllOrders() {
		return orderRepository.findAll();
	}

	public List<Orders> getOderListByDate(String date) {
		List<Orders> order = orderRepository.findOrdersByDate(date);
		System.out.println(order);
		return order;
	}

	public List<Orders> getOderListByDateAsc(String date) {
		List<Orders> order = orderRepository.findOrdersByDate(date);
		System.out.println(order);
		return order.stream().sorted(Comparator.comparing(Orders::getDate))
				.collect(Collectors.toList());
	}

	public List<Orders> oderByCity(String city) {
		List<Orders> order = orderRepository.findOrdersByProductAddressCity(city);
		System.out.println(order);
		return order;
	}


}