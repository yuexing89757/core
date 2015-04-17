package com.zzy.model.shard;

import com.zzy.model.supermodel.ModelObject;

public class Person extends ModelObject<Long> {

	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
