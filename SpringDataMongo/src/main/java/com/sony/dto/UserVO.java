package com.sony.dto;

import java.io.Serializable;

public class UserVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String userName;
	private String firstName;
	private String lastName;
	private boolean isDeleted = false;
	private Integer currentPage = 0;
	private Integer itemPerPage = 1;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getItemPerPage() {
		return itemPerPage;
	}

	public void setItemPerPage(Integer itemPerPage) {
		this.itemPerPage = itemPerPage;
	}
}