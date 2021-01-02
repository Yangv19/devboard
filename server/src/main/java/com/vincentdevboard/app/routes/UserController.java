package com.vincentdevboard.app.routes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vincentdevboard.app.auth.JWTAuth;
import com.vincentdevboard.app.entities.User;
import com.vincentdevboard.app.requests.LoginRequest;
import com.vincentdevboard.app.responses.DeletedResponse;
import com.vincentdevboard.app.responses.TokenResponse;
import com.vincentdevboard.app.services.UserService;
import com.vincentdevboard.app.services.ValidationService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private ValidationService validateService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTAuth auth;
	
	@PostMapping("/register")
	public ResponseEntity<TokenResponse> register(@RequestBody @Valid User user, BindingResult result) {
		validateService.validateInput(result);
		String id = userService.createUser(user);
		String token = auth.register(id);
		return new ResponseEntity<TokenResponse>(new TokenResponse(token), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest login, BindingResult result) {
		validateService.validateInput(result);
		String token = auth.login(login);
		return new ResponseEntity<TokenResponse>(new TokenResponse(token), HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<User> getUser(@RequestHeader("x-auth-token") String token) {
		String id = auth.authenticate(token);
		User user = userService.findUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PatchMapping("")
	public ResponseEntity<User> updateUser(@RequestHeader("x-auth-token") String token, @RequestParam("img") MultipartFile file) {
		String id = auth.authenticate(token);
		validateService.validateImage(file);
		User user = userService.updateUserImage(id, file);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("")
	public ResponseEntity<DeletedResponse> deleteUser(@RequestHeader("x-auth-token") String token) {
		String id = auth.authenticate(token);
		userService.deleteUser(id);
		return new ResponseEntity<DeletedResponse>(new DeletedResponse(), HttpStatus.OK);
	}
		
}
