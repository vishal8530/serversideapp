package com.applicationform.Applicationdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.applicationform.Applicationdemo.entity.User;
import com.applicationform.Applicationdemo.repo.UserRepository;

@Service
public class Userserviceimpl implements UserService {

	@Autowired
	private UserRepository userrepo;

	@Override
	public User createuser(User user) {

		User createuser = userrepo.save(user);

		return createuser;
	}

	@Override
	public List<User> getallusers() {

		List<User> getallusers = userrepo.findAll();

		return getallusers;
	}

	@Override
	public User getoneuser(Long id) {

		User user = userrepo.findById(id).get();
		return user;
	}

	@Override
	public User Updateuser(User user, Long id) {
		System.out.println("In service");
		User user2 = userrepo.findById(id).get();
		System.out.println("Check = " + user2.getFirstname());
		userrepo.save(user2);

		return user2;
	}

	@Override
	public void deleteuser(Long id) {

		// Optional<User> findById = userrepo.findById(id);

		userrepo.deleteById(id);
	}

	@Override
	public List<User> getalluserbycity(String district) {

		List<User> findAll = userrepo.findAll();

		List<User> collect = (List<User>) findAll.stream().filter(rec -> rec.getDistrict().equals(district))
				.collect(Collectors.toList());

		return collect;
	}

}
