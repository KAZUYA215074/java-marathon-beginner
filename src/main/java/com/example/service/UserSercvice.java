package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.Ex20Repository;

@Service
@Transactional
public class UserSercvice {

	@Autowired
	private Ex20Repository repository;
	
	public User load(Integer id) {
		return repository.load(id);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
}
