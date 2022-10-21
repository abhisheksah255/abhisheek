package com.abhisheksah.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhisheksah.model.Owner;
import com.abhisheksah.repository.OwnerRepository;

@Service
public class OwnerService implements UserDetailsService {
	
	
	@Autowired
	private OwnerRepository ownerRepo;

//
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Owner foundedUser=ownerRepo.findByEmail(email);
		if (foundedUser==null) {
			return null;
		}
		String email1=foundedUser.getEmail();
		String pass=foundedUser.getPassword();
		return new User(email1, pass,new ArrayList<>());
	}

}
