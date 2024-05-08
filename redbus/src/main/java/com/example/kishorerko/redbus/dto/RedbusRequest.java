package com.example.kishorerko.redbus.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class RedbusRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long busId;
	private int busNo;
	private String busName;
	private String boarding_point;
	private String dropping_point;
	
	
	
	public RedbusRequest() {		
		
	}

	public RedbusRequest(Long busId, int busNo, String busName, String boarding_point, String dropping_point) {
		super();
		this.busId = busId;
		this.busNo = busNo;
		this.busName = busName;
		this.boarding_point = boarding_point;
		this.dropping_point = dropping_point;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
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
		return "RedbusRequest [busId=" + busId + ", busNo=" + busNo + ", busName=" + busName + ", boarding_point="
				+ boarding_point + ", dropping_point=" + dropping_point + "]";
	}
	
	

}
