package com.technosmithlabs.springwithdrools.model;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	private String status;
	private String subStatus;

	public Response() {

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

}
