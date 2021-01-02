package com.vincentdevboard.app.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Dislike {

	@DBRef
	User user;
	
	public Dislike(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
