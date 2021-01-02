package com.vincentdevboard.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincentdevboard.app.DAO.PostDAO;
import com.vincentdevboard.app.entities.Post;
import com.vincentdevboard.app.exceptions.SingleException;

@Service
public class PostService {
	
	@Autowired
	private PostDAO postDAO;
	
	public void validPost(String postId) {
		Post post = postDAO.getPostById(postId);
		
		if (post == null) {
			throw new SingleException("Post does not exist");
		}
	}
	
	public void validPostModification(String userId, String postId) {
		Post post = getPostById(postId);
		
		if (!post.getUser().getUserId().equals(userId)) {
			throw new SingleException("User is not authorized");
		}
	}
	
	public void createPost(Post post, String userId) {
		postDAO.create(post, userId);
	}
	
	public List<Post> getPosts() {
		return postDAO.getPosts();
	}
	
	public Post getPostById(String id) {
		validPost(id);
		return postDAO.getPostById(id);
	}
	
	public void deletePost(String userId, String postId) {
		validPostModification(userId, postId);
		postDAO.deletePost(postId);
	}
}
