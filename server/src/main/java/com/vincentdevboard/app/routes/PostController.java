package com.vincentdevboard.app.routes;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincentdevboard.app.auth.JWTAuth;
import com.vincentdevboard.app.entities.Post;
import com.vincentdevboard.app.responses.DeletedResponse;
import com.vincentdevboard.app.services.PostService;
import com.vincentdevboard.app.services.ValidationService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private ValidationService validateService;
	
	@Autowired
	private JWTAuth auth;
	
	@Autowired
	private PostService postService;
	
	@PostMapping("")
	public ResponseEntity<Post> createPost(@RequestHeader("x-auth-token") String token, @RequestBody @Valid Post post, BindingResult result) {
		String id = auth.authenticate(token);
		validateService.validateInput(result);
		postService.createPost(post, id);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Post>> getPosts() {
		List<Post> posts = postService.getPosts();
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
	
	@GetMapping("/{postId}")
	public ResponseEntity<Post> getPost(@PathVariable String postId) {
		Post post = postService.getPostById(postId);
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<DeletedResponse> deletePost(@RequestHeader("x-auth-token") String token, @PathVariable String postId) {
		String userId = auth.authenticate(token);
		postService.deletePost(userId, postId);
		return new ResponseEntity<DeletedResponse>(new DeletedResponse(), HttpStatus.OK);
	}
}
