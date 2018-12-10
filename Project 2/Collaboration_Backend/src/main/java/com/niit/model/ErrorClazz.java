package com.niit.model;

public class ErrorClazz {
private int errorCode;
private String errorMessage;
public int getErrorcode() {
	return errorCode;
}
public void setErrorcode(int errorcode) {
	this.errorCode = errorcode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public ErrorClazz(int errorcode, String errorMessage) {
 super();
 this.errorCode = errorCode;
 this.errorMessage = errorMessage;
}

}