package com.restaurent.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private long resourceid;
	
	

	public ResourceNotFoundException(long resourceid) {
		
		super("Resource not found with id"+resourceid);
		this.resourceid = resourceid;
		
	}

	public long getResourceid() {
		return resourceid;
	}
	
	
}
