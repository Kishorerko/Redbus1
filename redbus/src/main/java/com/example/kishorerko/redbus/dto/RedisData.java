package com.example.kishorerko.redbus.dto;

public class RedisData {
	
	private PostToPreMTN postToPreMTN;
	
	
	public RedisData() {
		super();
	}

	public RedisData(PostToPreMTN postToPreMTN) {
		super();
		this.postToPreMTN = postToPreMTN;
	}

	public PostToPreMTN getPostToPreMTN() {
		return postToPreMTN;
	}

	public void setPostToPreMTN(PostToPreMTN postToPreMTN) {
		this.postToPreMTN = postToPreMTN;
	}
	
	
}
