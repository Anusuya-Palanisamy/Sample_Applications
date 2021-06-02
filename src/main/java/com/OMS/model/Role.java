package com.OMS.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	  ROLE_CUSTOMER, ROLE_SYSTEM_ADMIN, ROLE_SUPER_ADMIN;

	  public String getAuthority() {
	    return name();
	  }

	}
