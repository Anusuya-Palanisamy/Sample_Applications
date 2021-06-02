package com.OMS.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserSeq")
public class UserSeq {

	/*
	 * Data declared
	 */
	@Id
	private String id;
	private Long seq;

	/*
	 * Implement Getter and Setter
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

}
