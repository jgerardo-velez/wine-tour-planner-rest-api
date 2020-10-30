package edu.cetys.springlabs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cetys.springlabs.model.User;
import edu.cetys.springlabs.repository.UserRepository;


@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		
		List<User> dbUsers = userRepository.findAll();
		
	    return dbUsers;
	}
	
	public User findByEmail(String email) throws Exception {
		
		Optional<User> optionalUser = userRepository.findByEmail(email);
		
		optionalUser.orElseThrow(() -> new Exception("User Not Found: " + email));
		
		User dbUser = optionalUser.get(); 
		
		
		return dbUser;
	}
	
}
