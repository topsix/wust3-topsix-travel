package model;

import beans.User;

public class Jsonservlet<T> {
   String status;
   String message;
   String data;
   User user;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getData() {
	return data;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public void setData(String data) {
	this.data = data;
}
   
   
}

