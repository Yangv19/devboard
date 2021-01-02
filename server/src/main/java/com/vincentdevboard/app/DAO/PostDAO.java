package com.vincentdevboard.app.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.vincentdevboard.app.entities.Comment;
import com.vincentdevboard.app.entities.Dislike;
import com.vincentdevboard.app.entities.Like;
import com.vincentdevboard.app.entities.Post;
import com.vincentdevboard.app.entities.User;
import com.vincentdevboard.app.services.UserService;

@Component
public class PostDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserService userService;
	
	public void create(Post post, String userId) {
		User user = userService.findUserById(userId);
		post.setUser(user);
		this.mongoTemplate.insert(post, "post");
	}
	
	public List<Post> getPosts() {
		List<Post> posts = this.mongoTemplate.findAll(Post.class);
		Collections.sort(posts);
		return posts;
	}
	
	public Post getPostById(String id) {
		return mongoTemplate.findById(id, Post.class);
	}
	
	public void deletePost(String id) {
		Query queryPost = new Query();
		queryPost.addCriteria(Criteria.where("_id").is(id));
		mongoTemplate.findAndRemove(queryPost, Post.class);
		
		Query queryComment = new Query();
		queryComment.addCriteria(Criteria.where("post").is(id));
		mongoTemplate.findAndRemove(queryComment, Comment.class);
	}
	
	public boolean likeExists(String userId, String postId) {
		Post post = getPostById(postId);
		
		for (Like like : post.getLikes()) {
			if (like.getUser().getUserId().equals(userId)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addLike(String userId, String postId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(postId));
		Post post = getPostById(postId);
		User user = userService.findUserById(userId);
		List<Like> likes = post.getLikes();
		likes.add(new Like(user));
		Update update = new Update();
		update.set("likes", likes);
		mongoTemplate.findAndModify(query, update, Post.class);
	}
	
	public void removeLike(String userId, String postId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(postId));
		Post post = getPostById(postId);
		List<Like> likes = new ArrayList<Like>();
		
		for (Like like : post.getLikes()) {
			if (!like.getUser().getUserId().equals(userId)) {
				likes.add(like);
			}
		}
		
		Update update = new Update();
		update.set("likes", likes);
		mongoTemplate.findAndModify(query, update, Post.class);
	}
	
	public boolean dislikeExists(String userId, String postId) {
		Post post = getPostById(postId);
		
		for (Dislike dislike : post.getDislikes()) {
			if (dislike.getUser().getUserId().equals(userId)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void addDislike(String userId, String postId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(postId));
		Post post = getPostById(postId);
		User user = userService.findUserById(userId);
		List<Dislike> dislikes = post.getDislikes();
		dislikes.add(new Dislike(user));
		Update update = new Update();
		update.set("dislikes", dislikes);
		mongoTemplate.findAndModify(query, update, Post.class);
	}
	
	public void removeDislike(String userId, String postId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(postId));
		Post post = getPostById(postId);
		List<Dislike> dislikes = new ArrayList<Dislike>();
		
		for (Dislike dislike : post.getDislikes()) {
			if (!dislike.getUser().getUserId().equals(userId)) {
				dislikes.add(dislike);
			}
		}
		
		Update update = new Update();
		update.set("dislikes", dislikes);
		mongoTemplate.findAndModify(query, update, Post.class);
	}
}
