package com.app.error;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	// error handler for @Valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", sdf.format(new Date()));
		body.put("status", status.value());

		// Get all errors
	/*	List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
*/
		ArrayList<String> errors=new ArrayList<>();
		for(FieldError f1 : ex.getBindingResult().getFieldErrors())
			errors.add(f1.getDefaultMessage());
			
			
		body.put("errors", errors);

		return new ResponseEntity<>(body, headers, status);

	}
	

}
