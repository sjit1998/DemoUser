package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import com.example.demo.userresponse.UserRequest;
import com.example.demo.userresponse.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo rep;

	@Autowired
	private UserService service;

	/*
	 * @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<UserResponse> addNewUser(@RequestBody UserRequest
	 * request) { User model = new User(); // n.setId(id);
	 * model.setName(request.getName()); model.setEmail(request.getEmail()); model =
	 * rep.save(model); UserResponse response = new UserResponse();
	 * response.setId(model.getId()); response.setName(model.getName());
	 * response.setEmail(model.getEmail());
	 * 
	 * return new ResponseEntity<>(response, HttpStatus.OK); }
	 */
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> addNewUser(@Valid @RequestBody UserRequest request) {
		User model = new User();
		model.setName(request.getName());
		model.setEmail(request.getEmail());
		UserResponse response = new UserResponse();
		Optional<User> user = rep.findByEmail(model.getEmail());
		if (!user.isPresent()) {
			model = rep.save(model);

			response.setId(model.getId());
			response.setName(model.getName());
			response.setEmail(model.getEmail());
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> UpdateUser(@RequestBody UserRequest request, @PathVariable Integer id) {
		User model = new User();
		model.setId(id);
		model.setName(request.getName());
		model.setEmail(request.getEmail());
		model = rep.save(model);
		UserResponse response = new UserResponse();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setEmail(model.getEmail());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		rep.deleteById(id);
		return new ResponseEntity<>("sucess", HttpStatus.OK);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserResponse>> list() {
		
		List<UserResponse> responses = service.getUserList();
		return new ResponseEntity<>(responses, HttpStatus.OK);
	}

}
