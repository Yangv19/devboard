package com.vincentdevboard.app.responses;

public class DislikeResponse {
	
	private String msg;
	
	public DislikeResponse(boolean deleted) {
 		if (deleted) {
 			this.msg = "Dislike removed";
 		} else {
 			this.msg = "Dislike added";
 		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
