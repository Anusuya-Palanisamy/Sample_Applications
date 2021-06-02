package com.OMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OMS.Request.OrderRequest;
import com.OMS.model.Orders;
import com.OMS.model.User;
import com.OMS.service.OrderService;
import com.OMS.service.UserService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value="Order", description="Operations Order Management System")
public class RestContoller {
	

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/user")
	private ResponseEntity createUser(@RequestBody User userRequest) {
		try {
			User user = userService.createUserData(userRequest);
			
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/userList")
	private ResponseEntity getUserDetails() {
		try {
			List<User> user = userService.findAllList();
			
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved Orders"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/createOrder", method= RequestMethod.POST, produces = "application/json")
//	@PostMapping(value = "/createOrder")
	private ResponseEntity createCustomerRequest(@RequestBody OrderRequest orderRequest) {
		try {
			Orders order = orderService.saveOrUpdateOrder(orderRequest);
			
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/CustomerOderDetails")
	private ResponseEntity getOrderDetials(@RequestParam String customerId) {
		try {
			List<Orders> order = orderService.getOderList(customerId);
			
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/OderList")
	private ResponseEntity getOrderList() {
		try {
			List<Orders> order = orderService.findAllOrders();
			
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/OrderListByData")
	private ResponseEntity OrderListByDateRange(@RequestParam String date) {
		try {
			List<Orders> order = orderService.getOderListByDate(date);
			
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/OrderListByDataAsc")
	private ResponseEntity OrderListByDateRangeASC(@RequestParam String date) {
		try {
			List<Orders> order = orderService.getOderListByDateAsc(date);
			
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/OrderByCity")
	private ResponseEntity OrderByCity(@RequestParam String city) {
		try {
			List<Orders> order = orderService.oderByCity(city);
			
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Create Cart method error {}");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
