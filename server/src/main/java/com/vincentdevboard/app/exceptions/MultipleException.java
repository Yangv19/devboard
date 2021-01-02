package com.vincentdevboard.app.exceptions;

import java.util.List;

@SuppressWarnings("serial")
public class MultipleException extends RuntimeException {
	private List<String> errors;
	
	public MultipleException(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
