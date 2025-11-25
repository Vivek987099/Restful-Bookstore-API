package com.example.DTO;

import java.time.LocalDateTime;

public class ApiErrorResponse {
	private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private String path;
	public ApiErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiErrorResponse(String message, int statusCode, LocalDateTime timestamp, String path) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	} 
    
    

}
