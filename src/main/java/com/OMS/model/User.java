package com.OMS.model;


import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.OMS.Request.BaseRequest;
import com.mongodb.lang.NonNull;

import lombok.*;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User{
	

	@Transient
	public static final String SEQUENCE_NAME = "UserSeq";
	
	@Id
	public String user_id;
	
	public@NonNull String userName;
	public @NonNull String password;
	public @NonNull  String emailId;
	public @NonNull  String role; 
	

}
