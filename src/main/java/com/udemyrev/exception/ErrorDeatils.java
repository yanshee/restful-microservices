package com.udemyrev.exception;

import java.time.LocalDateTime;


public class ErrorDeatils {
	private LocalDateTime timestamp;
	private String message;
	private String path;
	private String errorCode;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public ErrorDeatils(LocalDateTime timestamp, String message, String path, String errorCode) {
		// TODO Auto-generated constructor stub
		super();
		this.timestamp=timestamp;
		this.message=message;
		this.path=path;
		this.errorCode=errorCode;
	}

	

}
