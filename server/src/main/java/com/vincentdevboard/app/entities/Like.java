package com.vincentdevboard.app.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Like {

	@DBRef
	User user;
	
	public Like(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
