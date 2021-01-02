package com.vincentdevboard.app.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vincentdevboard.app.auth.JWTAuth;
import com.vincentdevboard.app.responses.DislikeResponse;
import com.vincentdevboard.app.responses.LikeResponse;
import com.vincentdevboard.app.services.DislikeService;
import com.vincentdevboard.app.services.LikeService;

@RestController
@RequestMapping("/api/posts")
public class LikeController {
	
	@Autowired
	private JWTAuth auth;
	
	@Autowired
	LikeService likeService;
	
	@Autowired
	DislikeService dislikeService;
	
	@PatchMapping("/likes/{postId}")
	public ResponseEntity<LikeResponse> addLike(@RequestHeader("x-auth-token") String token, @PathVariable String postId) {
		String userId = auth.authenticate(token);
		likeService.addLike(userId, postId);
		return new ResponseEntity<LikeResponse>(new LikeResponse(false), HttpStatus.OK);
	}
	
	@DeleteMapping("/likes/{postId}")
	public ResponseEntity<LikeResponse> removeLike(@RequestHeader("x-auth-token") String token, @PathVariable String postId) {
		String userId = auth.authenticate(token);
		likeService.removeLike(userId, postId);
		return new ResponseEntity<LikeResponse>(new LikeResponse(true), HttpStatus.OK);
	}
	
	@PatchMapping("/dislikes/{postId}")
	public ResponseEntity<DislikeResponse> addDislike(@RequestHeader("x-auth-token") String token, @PathVariable String postId) {
		String userId = auth.authenticate(token);
		dislikeService.addDislike(userId, postId);
		return new ResponseEntity<DislikeResponse>(new DislikeResponse(false), HttpStatus.OK);
	}
	
	@DeleteMapping("/dislikes/{postId}")
	public ResponseEntity<DislikeResponse> removeDislike(@RequestHeader("x-auth-token") String token, @PathVariable String postId) {
		String userId = auth.authenticate(token);
		dislikeService.removeDislike(userId, postId);
		return new ResponseEntity<DislikeResponse>(new DislikeResponse(true), HttpStatus.OK);
	}
}
