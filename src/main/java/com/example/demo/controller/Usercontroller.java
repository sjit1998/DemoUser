package com.example.demo.controller;

import java.util.List;

//import java.awt.PageAttributes.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.userresponse.UserRequest;
import com.example.demo.userresponse.UserResponse;

//import UserModel.UserResponse;
//import antlr.collections.List;

@RestController
@RequestMapping("/user")

public class Usercontroller {
	@Autowired
	private UserRepo rep;

	@GetMapping(value = "/list", produces=MediaType.APPLICATION_JSON_VALUE)
	//@GetMapping(value = "/list")
	public ResponseEntity<UserResponse> name() {
		
		UserResponse response = new UserResponse();
		response.setId(Integer.valueOf("120"));
		response.setName("Surajit");
		response.setEmail("surajit.naskar@indusnet.co.in");
		
		//List<UserResponse> list = new ArrayList<>();
		//list.add(response);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/*@PostMapping(path="/add")
	  public @ResponseBody String addNewUser (@RequestParam(value = "id", required =   
			  true)Integer id,@RequestParam String name,
		       @RequestParam String email) {  
	    User n = new User();
	    n.setId(id);
	    n.setName(name);
	    n.setEmail(email);
	    rep.save(n);
	    return "Saved";
	  }*/
	
	@PostMapping(path="/add",produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<UserResponse> addNewUser (@RequestBody UserRequest request) {  
	   User model = new User();
	    //n.setId(id);
	    model.setName(request.getName());
	    model.setEmail(request.getEmail());
	    model=rep.save(model);
	    UserResponse response = new UserResponse();
	    response.setId(model.getId());
	    response.setName(model.getName());
	    response.setEmail(model.getEmail());
		
	    return new ResponseEntity<>( response,HttpStatus.OK);
	  }

	  /*@GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    return rep.findAll();
	  }*/
	@GetMapping(path="/all")
	  public ResponseEntity<List<User>> getAllUsers() {
	    List<User> user=rep.findAll();
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
}
