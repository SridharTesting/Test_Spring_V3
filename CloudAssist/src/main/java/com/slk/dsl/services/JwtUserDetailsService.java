package com.slk.dsl.services;



import java.util.ArrayList;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slk.dsl.model.DAOUser;
import com.slk.dsl.model.UserDTO;
import com.slk.dsl.repository.UserDao;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.slk.dsl.model.DAOUser user = userDao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());
	}
	@Transactional
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setLobId(user.getLobId());
		newUser.setRecInsDt(user.getRecInsDt());
		newUser.setRecUpdDt(user.getRecUpdDt());
		newUser.setRecType(user.getRecType());
		newUser.setUser_role_id(user.getUser_role_id());
		
		
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
		
		return userDao.save(newUser);
	}



}