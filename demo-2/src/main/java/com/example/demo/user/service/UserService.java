package com.example.demo.user.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.vo.User;

@Service
@Transactional
public class UserService {

	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper){
		this.userMapper=userMapper;
	}
	
	public List<User> getUser(){
		return userMapper.selectUsers();
	}
	
	public User getUserForId(int id){
		return userMapper.selectUserForId(id);
	}
	
	public int addUser(User user){
		return userMapper.insert(user);
	}
	
	public int updateUser(User user){
		return userMapper.update(user);
	}
	
	public int deleteUser(int id){
		return userMapper.delete(id);
	}
	
	public int updateForError(User user){
		userMapper.update(user);
		throw new RuntimeErrorException(null);
	}
}
