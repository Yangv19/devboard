package com.vincentdevboard.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincentdevboard.app.DAO.PostDAO;
import com.vincentdevboard.app.exceptions.SingleException;

@Service
public class LikeService {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private PostService postService;
	
	public void addLike(String userId, String postId) {
		postService.validPost(postId);
		
		if (postDAO.likeExists(userId, postId)) {
			throw new SingleException("Post already liked");
		}
		
		postDAO.addLike(userId, postId);
	}
	
	public void removeLike(String userId, String postId) {
		postService.validPost(postId);

		if (!postDAO.likeExists(userId, postId)) {
			throw new SingleException("Post not yet liked");
		}
		
		postDAO.removeLike(userId, postId);
	}
}
