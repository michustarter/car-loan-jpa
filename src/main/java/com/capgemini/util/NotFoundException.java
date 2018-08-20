package com.capgemini.util;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3128197493698921277L;

	public NotFoundException(String message) {
        super(message);
    }
}
