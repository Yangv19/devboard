package com.vincentdevboard.app.entities;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Comment implements Comparable<Comment> {

	@Id
	private String commentId;
	
	private User user;
	
	@DBRef
	@JsonIgnore
	private Post post;
	
	@NotBlank(message = "Text is required")
	private String text;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date = new Date(System.currentTimeMillis());

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
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
	
	@Override
	public int compareTo(Comment o) {
		if (this.date.before(o.getDate())) {
			return -1;
		} else if (this.date.after(o.getDate())) {
			return 1;
		} else {
			return 0;
		}
	}
}
