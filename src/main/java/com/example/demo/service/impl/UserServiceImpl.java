package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import com.example.demo.userresponse.UserRequest;
import com.example.demo.userresponse.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo rep;

	@Override
	public List<UserResponse> getUserList() {

		List<User> user = rep.findAll();

		List<UserResponse> responses = user.stream().map(data -> {
			UserResponse response = new UserResponse();
			response.setId(data.getId());
			response.setName(data.getName());
			response.setEmail(data.getEmail());
			return response;
		}).collect(Collectors.toList());

		return responses;
	}

	@Override
	public UserResponse createUser(UserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse updateUser(UserRequest request, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
