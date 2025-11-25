package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.DTO.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> resoursesNotFoundExceptionHandler(ResourcesNotFoundException ex,
			WebRequest request) {
		ApiErrorResponse apiErrorResponse = new ApiErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now(), request.getDescription(false));

		return new ResponseEntity<ApiErrorResponse>(apiErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ApiErrorResponse> noResourceFoundExceptionHandler(NoResourceFoundException ex,
			WebRequest request) {
		ApiErrorResponse apiErrorResponse = new ApiErrorResponse("Invalid API path or endpoint not found",
				HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), request.getDescription(false));

		return new ResponseEntity<ApiErrorResponse>(apiErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiErrorResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String message = String.format("Invalid value '%s' for parameter '%s'. Expected type: %s", ex.getValue(),
				ex.getName(), ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown");
		ApiErrorResponse apiErrorResponse = new ApiErrorResponse(message, HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now(), request.getDescription(false));
		return new ResponseEntity<ApiErrorResponse>(apiErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
