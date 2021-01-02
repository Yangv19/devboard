package com.vincentdevboard.app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Post implements Comparable<Post> {
	
	@Id
	private String postId;
	
	private User user;
	
	@NotBlank(message = "Text is required")
	private String text;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date = new Date(System.currentTimeMillis());
	
	private List<Like> likes = new ArrayList<Like>();
	
	private List<Dislike> dislikes = new ArrayList<Dislike>();

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Dislike> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<Dislike> dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public int compareTo(Post o) {
		if (this.date.before(o.getDate())) {
			return -1;
		} else if (this.date.after(o.getDate())) {
			return 1;
		} else {
			return 0;
		}
	}
}
