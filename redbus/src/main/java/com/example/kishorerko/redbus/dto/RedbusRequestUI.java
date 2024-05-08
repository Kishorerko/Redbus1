package com.example.kishorerko.redbus.dto;

import lombok.Data;

@Data
public class RedbusRequestUI {
	
	private int busNo;
	private String busName;
	private String customerName;
	private String boarding_point;
	private String dropping_point;
	public RedbusRequestUI(int busNo, String busName, String customerName, String boarding_point,
			String dropping_point) {
		super();
		this.busNo = busNo;
		this.busName = busName;
		this.customerName = customerName;
		this.boarding_point = boarding_point;
		this.dropping_point = dropping_point;
	}
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBoarding_point() {
		return boarding_point;
	}
	public void setBoarding_point(String boarding_point) {
		this.boarding_point = boarding_point;
	}
	public String getDropping_point() {
		return dropping_point;
	}
	public void setDropping_point(String dropping_point) {
		this.dropping_point = dropping_point;
	}
	@Override
	public String toString() {
		return "RedbusRequestUI [busNo=" + busNo + ", busName=" + busName + ", customerName=" + customerName
				+ ", boarding_point=" + boarding_point + ", dropping_point=" + dropping_point + "]";
	}
	
	
	

}
