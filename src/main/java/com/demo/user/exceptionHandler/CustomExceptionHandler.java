package com.demo.user.exceptionHandler;

import java.util.Date;

public class CustomExceptionHandler {

	private String message;
	public CustomExceptionHandler(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	private Date date;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
