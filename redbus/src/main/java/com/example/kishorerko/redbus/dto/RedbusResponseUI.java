package com.example.kishorerko.redbus.dto;

import lombok.Data;

@Data
public class RedbusResponseUI {
	
	private long busId;
	private String message;
	public RedbusResponseUI(long busId, String message) {
		super();
		this.busId = busId;
		this.message = message;
	}
	public RedbusResponseUI() {
		
	}
	public long getBusId() {
		return busId;
	}
	public void setBusId(long busId) {
		this.busId = busId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "RedbusResponseUI [busId=" + busId + ", message=" + message + "]";
	}
	
	

}
