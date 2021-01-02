package com.vincentdevboard.app.responses;

public class CommentResponse {
	
	private String msg;
	
	public CommentResponse(boolean deleted) {
 		if (deleted) {
 			this.msg = "Comment removed";
 		} else {
 			this.msg = "Comment added";
 		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
