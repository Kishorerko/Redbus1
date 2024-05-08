package com.example.kishorerko.redbus.dto;


public class UserMembers {
	
	private String mtn;
	private String numberFreezeStatus;
	
	public UserMembers(String mtn, String numberFreezeStatus) {
		super();
		this.mtn = mtn;
		this.numberFreezeStatus = numberFreezeStatus;
	}

	public UserMembers() {
		
	}

	public String getMtn() {
		return mtn;
	}

	public void setMtn(String mtn) {
		this.mtn = mtn;
	}

	public String getNumberFreezeStatus() {
		return numberFreezeStatus;
	}

	public void setNumberFreezeStatus(String numberFreezeStatus) {
		this.numberFreezeStatus = numberFreezeStatus;
	}
	
	
}
