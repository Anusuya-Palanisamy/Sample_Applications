package com.OMS.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OMS.Request.OrderRequest;
import com.OMS.model.Orders;

import reactor.core.publisher.Mono;

public interface OrderRepository extends MongoRepository<Orders, String> {

	List<Orders> findOrdersByCustomerId(String customerId);

	List<Orders> findOrdersByDate(String date);

	List<Orders> findOrdersByProductAddressCity(String city);
}
