package com.root.exception;

public class InvalidEmailORUserIdException extends Exception {
	public InvalidEmailORUserIdException() {
		System.out.println("InvalidEmailORUserIdException.InvalidEmailORUserIdException()");
	}

	public InvalidEmailORUserIdException(String message) {
		super(message);
	}

}