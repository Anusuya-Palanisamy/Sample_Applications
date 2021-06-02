package com.OMS.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.mongodb.lang.NonNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String order_id;

	private @NonNull String customerId;
    
	private @NonNull String date;
	
	private @NonNull List<Product> product;
	
	private @NonNull List<InvoiceData> invoiceData;

}
