package com.vincentdevboard.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincentdevboard.app.DAO.PostDAO;
import com.vincentdevboard.app.exceptions.SingleException;

@Service
public class DislikeService {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private PostService postService;
	
	public void addDislike(String userId, String postId) {
		postService.validPost(postId);
		
		if (postDAO.dislikeExists(userId, postId)) {
			throw new SingleException("Post already disliked");
		}
		
		postDAO.addDislike(userId, postId);
	}
	
	public void removeDislike(String userId, String postId) {
		postService.validPost(postId);

		if (!postDAO.dislikeExists(userId, postId)) {
			throw new SingleException("Post not yet disliked");
		}
		
		postDAO.removeDislike(userId, postId);
	}
}
