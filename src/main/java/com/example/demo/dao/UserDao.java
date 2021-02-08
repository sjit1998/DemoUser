package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;



public class UserDao {
	@Autowired
	private UserRepo rep;
   public User getusersById(int id) 
   {  
   return rep.findById(id).get();
   } 
   
   public void save(User user) {
		rep.save(user);
}	
   public void update(User user)   
   {  
     rep.save(user);  
   } 
   public void delete(int id)   
   {  
   rep.deleteById(id);  
   }  

}
