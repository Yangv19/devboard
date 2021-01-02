package com.vincentdevboard.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vincentdevboard.app.DAO.CommentDAO;
import com.vincentdevboard.app.entities.Comment;
import com.vincentdevboard.app.exceptions.SingleException;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private PostService postService;
	
	public void validComment(String commentId) {
		Comment comment = commentDAO.getCommentById(commentId);
		
		if (comment == null) {
			throw new SingleException("Comment does not exist");
		}
	}
	
	public void validCommentModification(String userId, String postId, String commentId) {
		Comment comment = commentDAO.getCommentById(commentId);
		
		if (!comment.getPost().getPostId().equals(postId)) {
			throw new SingleException("Comment does not exist on post");
		} else if (!comment.getUser().getUserId().equals(userId)) {
			throw new SingleException("User is not authorized");
		}
	}
	
	public void addComment(String userId, String postId, Comment comment) {
		postService.validPost(postId);
		commentDAO.addComment(userId, postId, comment);
	}
	
	public void removeComment(String userId, String postId, String commentId) {
		postService.validPost(postId);
		validComment(commentId);
		validCommentModification(userId, postId, commentId);
		commentDAO.deleteComment(commentId);
	}
	
	public List<Comment> getComments(String postId) {
		return commentDAO.getComments(postId);
	}
}
