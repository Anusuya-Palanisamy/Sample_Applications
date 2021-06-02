package com.OMS.Request;


import com.OMS.model.Address;
import com.OMS.model.Product;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderRequest extends BaseRequest {

	private String customerId;
	private Product product;
	private Address address;
	private String mobileNumber;
	
}
