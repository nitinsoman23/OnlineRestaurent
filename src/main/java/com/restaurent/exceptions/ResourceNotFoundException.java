package com.restaurent.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {

	private long resourceid;
	
	private String operation;

	public ResourceNotFoundException(long resourceid,String operation) {
		
		super("Resource not found with id "+resourceid+" while "+operation);
		this.resourceid = resourceid;
		
	}

	public long getResourceid() {
		return resourceid;
	}

	public String getOperation() {
		return operation;
	}
	
	
}
