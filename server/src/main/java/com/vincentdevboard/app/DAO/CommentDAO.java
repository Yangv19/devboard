package com.vincentdevboard.app.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.vincentdevboard.app.entities.Comment;
import com.vincentdevboard.app.entities.Post;
import com.vincentdevboard.app.entities.User;
import com.vincentdevboard.app.services.UserService;

@Component
public class CommentDAO {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void addComment(String userId, String postId, Comment comment) {
		Post post = postDAO.getPostById(postId);
		User user = userService.findUserById(userId);
		comment.setUser(user);
		comment.setPost(post);
		this.mongoTemplate.insert(comment, "comment");
	}
	
	public Comment getCommentById(String id) {
		return mongoTemplate.findById(id, Comment.class);
	}
	
	public void deleteComment(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		mongoTemplate.findAndRemove(query, Comment.class);
	}
	
	public List<Comment> getComments(String postId) {
		List<Comment> comments = this.mongoTemplate.findAll(Comment.class);
		Collections.sort(comments);
		List<Comment> commentsNeeded = new ArrayList<Comment>();
		
		for (Comment comment : comments) {
			if (comment.getPost().getPostId().equals(postId)) {
				commentsNeeded.add(comment);
			}
		}
		
		return commentsNeeded;
	}
}
