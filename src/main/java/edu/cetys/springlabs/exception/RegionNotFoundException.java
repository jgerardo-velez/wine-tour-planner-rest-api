package edu.cetys.springlabs.exception;


public class RegionNotFoundException extends RuntimeException {

	public RegionNotFoundException(int id) {
		super("Region not found: " + id);
	}
	
}
