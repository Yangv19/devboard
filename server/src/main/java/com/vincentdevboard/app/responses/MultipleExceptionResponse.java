package com.vincentdevboard.app.responses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleExceptionResponse {
	private List<Map<String, String>> errors;
	
	public MultipleExceptionResponse(List<String> errors) {
		this.errors = new ArrayList<Map<String, String>>();
		for (String error : errors) {
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("msg", error);
			this.errors.add(msg);
		}
	}

	public List<Map<String, String>> getErrors() {
		return errors;
	}

	public void setErrors(List<Map<String, String>> errors) {
		this.errors = errors;
	}
}
