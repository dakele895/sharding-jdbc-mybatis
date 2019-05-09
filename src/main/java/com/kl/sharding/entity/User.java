package com.kl.sharding.entity;

import java.io.Serializable;

/**
 * 用户类
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String userId;

	private String name;

	private Integer age;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", name=" + name + ", age=" + age + "]";
	}

}