package com.example.demo.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.service.UserService;
import com.example.demo.user.vo.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService){
		this.userService=userService;
	}
	
	@RequestMapping(path="/exception", method=RequestMethod.GET)
	public String getUsers1() throws Exception{
		throw new Exception();
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<User> getUsers(){
		return userService.getUser();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable int id, HttpServletRequest request){
		
		/*User user = userService.getUserForId(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		*/
		return userService.getUserForId(id);
	}
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public int createUser(@Valid @RequestBody User user){
		return userService.addUser(user);
	}
	
	@RequestMapping(path="", method=RequestMethod.PUT)
	public int modifyUser(@Valid @RequestBody User user){
		return userService.updateUser(user);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public int deleteUser(@Valid @PathVariable int id){
		return userService.deleteUser(id);
	}
	
}
