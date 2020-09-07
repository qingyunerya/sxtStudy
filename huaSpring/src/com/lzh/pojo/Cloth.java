package com.lzh.pojo;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Cloth {
	
	private Long id;
	
	private String name;
	
//	@Autowired
	@Resource(name="user")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}
//	@Autowired
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
