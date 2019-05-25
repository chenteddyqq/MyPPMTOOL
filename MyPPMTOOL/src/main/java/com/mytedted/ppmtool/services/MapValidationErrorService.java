package com.mytedted.ppmtool.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapValidationErrorService {

	public ResponseEntity<?> mapValidationErrorService(BindingResult bindResult){
		if(bindResult.hasErrors()) {	
			Map<String, String> errorMap = new HashMap<String, String>();
			for (FieldError iterable_element : bindResult.getFieldErrors()) {
				errorMap.put(iterable_element.getField(), iterable_element.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
