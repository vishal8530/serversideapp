package com.applicationform.Applicationdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applicationform.Applicationdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
	public List<User> findByDistrict( String district);
	
	

}
