package com.algaworks.algalog.api.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandError{
	
	private List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addError(String fieldName,String fieldMessage) {
		errors.add(new FieldMessage(fieldName,fieldMessage));
	}
}
