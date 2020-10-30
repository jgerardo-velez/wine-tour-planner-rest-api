package edu.cetys.springlabs.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.cetys.springlabs.exception.RegionNotFoundException;


@ControllerAdvice
public class RegionNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(RegionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String regionNotFoundHandler(RegionNotFoundException ex) {
		return ex.getMessage();
	}
}
