package com.example.kishorerko.redbus.dto;

public class CXPData {
	
	private PostToPreMTN postToPreMTN;	

	private String caseId;

	public CXPData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CXPData(PostToPreMTN postToPreMTN, String caseId) {
		super();
		this.postToPreMTN = postToPreMTN;
		this.caseId = caseId;
	}

	public PostToPreMTN getPostToPreMTN() {
		return postToPreMTN;
	}

	public void setPostToPreMTN(PostToPreMTN postToPreMTN) {
		this.postToPreMTN = postToPreMTN;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	

}
