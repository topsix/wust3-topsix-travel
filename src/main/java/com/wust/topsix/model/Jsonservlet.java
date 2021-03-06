package com.wust.topsix.model;

import com.wust.topsix.beans.Sight;
import com.wust.topsix.beans.User;

public class Jsonservlet<T> {
	String status;
	String message;
	String data;
	User user;
	Sight sight;

	public Sight getSight() {
		return sight;
	}

	public void setSight(Sight sight) {
		this.sight = sight;
	}

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
