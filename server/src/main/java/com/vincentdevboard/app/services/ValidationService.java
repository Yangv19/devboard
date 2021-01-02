package com.vincentdevboard.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import com.vincentdevboard.app.exceptions.MultipleException;
import com.vincentdevboard.app.exceptions.SingleException;

@Service
public class ValidationService {
	
	public void validateInput(BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			
			for (FieldError error : result.getFieldErrors()) {
				errors.add(error.getDefaultMessage());
			}
			
			throw new MultipleException(errors);
		}
	}
	
	public void validateImage(MultipartFile file) {
		if (!(file.getContentType().equals("image/png") || file.getContentType().equals("image/jpeg"))) {
			throw new SingleException("Must upload image");
		}
	}
}
