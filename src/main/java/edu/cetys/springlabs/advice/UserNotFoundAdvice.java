package edu.cetys.springlabs.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.cetys.springlabs.exception.UserNotFoundException;


@ControllerAdvice
public class UserNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	String regionNotFoundHandler(UserNotFoundException ex) {
		return ex.getMessage();
	}
	
}
