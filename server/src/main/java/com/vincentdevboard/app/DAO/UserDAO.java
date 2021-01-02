package com.vincentdevboard.app.DAO;

import java.io.File;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vincentdevboard.app.entities.Post;
import com.vincentdevboard.app.entities.User;
import com.vincentdevboard.app.exceptions.SingleException;

@Component
public class UserDAO {

	@Autowired
	PostDAO postDAO;
	
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public UserDAO(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		this.mongoTemplate.indexOps("user").ensureIndex(new Index("username", Direction.ASC).unique());
		this.mongoTemplate.indexOps("user").ensureIndex(new Index("email", Direction.ASC).unique());
	}
	
	public void create(User user) {

		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(new File(System.getProperty("user.dir") + "/images/default.png"));
		} catch (Exception e) {
			throw new SingleException("Server Error");
		}
		
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		user.setAvatar(encodedString);
		this.mongoTemplate.insert(user, "user");
	}
	
	public User findUserByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		User user = mongoTemplate.findOne(query, User.class);
		return user;
	}
	
	public User findUserById(String id) {
		return mongoTemplate.findById(id, User.class);
	}
	
	public User updateUserImage(String id, MultipartFile file) {
		String encodedString = null;
		
		try {
			encodedString = Base64.getEncoder().encodeToString(file.getBytes());
		} catch (Exception e) {
			throw new SingleException("Server Error");
		}
		
		Query query = new Query();
		Update update = new Update();
		query.addCriteria(Criteria.where("_id").is(id));
		update.set("avatar", encodedString);
		mongoTemplate.findAndModify(query, update, User.class);
		return findUserById(id);
	}
	
	public void deleteUser(String id) {
		
		for (Post post : postDAO.getPosts()) {
			if (post.getUser().getUserId().equals(id)) {
				postDAO.deletePost(post.getPostId());
				continue;
			}
			
			if (postDAO.likeExists(id, post.getPostId())) {
				postDAO.removeLike(id, post.getPostId());
			}
			
			if (postDAO.dislikeExists(id, post.getPostId())) {
				postDAO.removeDislike(id, post.getPostId());
			}
		}
		
		Query queryPost = new Query();
		queryPost.addCriteria(Criteria.where("_id").is(id));
		mongoTemplate.findAndRemove(queryPost, User.class);
	}
	
}
