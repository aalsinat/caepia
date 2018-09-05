package com.caepia.app.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotExistingUserException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final String message;
}
