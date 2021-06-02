package com.OMS.Request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseRequest implements Serializable {

    private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}