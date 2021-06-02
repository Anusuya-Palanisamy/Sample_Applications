package com.OMS.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "address")
public class Address {

	/*
	 * Data declared
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressid;
	public String addressDetails;
	public String city;
	public String state;
	public long pincode;
}
