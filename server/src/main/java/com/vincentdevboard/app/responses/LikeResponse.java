package com.vincentdevboard.app.responses;

public class LikeResponse {

	private String msg;
	
	public LikeResponse(boolean deleted) {
 		if (deleted) {
 			this.msg = "Like removed";
 		} else {
 			this.msg = "Like added";
 		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
