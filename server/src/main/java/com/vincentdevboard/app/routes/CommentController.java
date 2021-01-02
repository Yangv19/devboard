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
import com.vincentdevboard.app.entities.Comment;
import com.vincentdevboard.app.responses.CommentResponse;
import com.vincentdevboard.app.services.CommentService;
import com.vincentdevboard.app.services.ValidationService;

@RestController
@RequestMapping("/api/posts")
public class CommentController {
	
	@Autowired
	private JWTAuth auth;
	
	@Autowired
	private ValidationService validateService;
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comments/{postId}")
	public ResponseEntity<CommentResponse> createComment(@RequestHeader("x-auth-token") String token, @PathVariable String postId, 
													     @RequestBody @Valid Comment comment, BindingResult result) {
		String userId = auth.authenticate(token);
		validateService.validateInput(result);
		commentService.addComment(userId, postId, comment);
		return new ResponseEntity<CommentResponse>(new CommentResponse(false), HttpStatus.OK);
	}
	
	@DeleteMapping("/comments/{postId}/{commentId}")
	public ResponseEntity<CommentResponse> deleteComment(@RequestHeader("x-auth-token") String token, @PathVariable String postId, 
									 					 @PathVariable String commentId) {
		String userId = auth.authenticate(token);
		commentService.removeComment(userId, postId, commentId);
		return new ResponseEntity<CommentResponse>(new CommentResponse(true), HttpStatus.OK);
	}
	
	@GetMapping("/comments/{postId}")
	public ResponseEntity<List<Comment>> getComments(@PathVariable String postId) {
		List<Comment> comments = commentService.getComments(postId);
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
}
