package com.example.demo.service;

import java.util.List;

import com.example.demo.userresponse.UserRequest;
import com.example.demo.userresponse.UserResponse;

public interface UserService {

	List<UserResponse> getUserList();

	UserResponse createUser(UserRequest request);

	UserResponse updateUser(UserRequest request, Long userId);

	Boolean deleteUser(Long userId);
}
