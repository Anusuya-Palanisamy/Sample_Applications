package com.OMS.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Products")
public class Product {
	
	String productId;
	String productName;
	String description;
	String price;
	public Address address;

}
