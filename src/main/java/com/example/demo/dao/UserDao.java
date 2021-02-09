package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Component
public class UserDao {
	@Autowired
	private UserRepo rep;

	public User getusersById(int id) {
		return rep.findById(id).get();
	}

	public void save(User user) {
		rep.save(user);
	}

	public void update(User user) {
		rep.save(user);
	}

	public void delete(int id) {
		rep.deleteById(id);
	}

	public boolean check(User user) {
		List<User> list=rep.findAll();
		for (User u : list) {
			if(user.getEmail().equals(u.getEmail()))
				return true;
		}
		return false;
	}

}
