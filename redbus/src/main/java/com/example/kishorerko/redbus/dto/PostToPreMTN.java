package com.example.kishorerko.redbus.dto;

import java.util.List;

public class PostToPreMTN {
	
	private List<UserMembers> userMembers;

	public PostToPreMTN(List<UserMembers> userMembers) {
		super();
		this.userMembers = userMembers;
	}

	public PostToPreMTN() {
	}

	public List<UserMembers> getUserMembers() {
		return userMembers;
	}

	public void setUserMembers(List<UserMembers> userMembers) {
		this.userMembers = userMembers;
	}
	
	

}
