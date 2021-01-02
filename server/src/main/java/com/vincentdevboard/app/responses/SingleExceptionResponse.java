package com.vincentdevboard.app.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleExceptionResponse {
private List<Map<String, String>> errors;
	
	public SingleExceptionResponse(String error) {
		this.errors = new ArrayList<Map<String, String>>();
		Map<String, String> msg = new HashMap<String, String>();
		msg.put("msg", error);
		this.errors.add(msg);
	}

	public List<Map<String, String>> getErrors() {
		return errors;
	}

	public void setErrors(List<Map<String, String>> errors) {
		this.errors = errors;
	}
}
