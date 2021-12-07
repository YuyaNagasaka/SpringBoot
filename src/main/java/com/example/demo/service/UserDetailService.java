package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {
	@Autowired UserService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
    	com.example.demo.object.User login_user = service.findUser(username);//idを引数に取れているか？
    	
    	if (login_user == null) {
    		 throw new UsernameNotFoundException("user not found");
        }
    	
    	List<GrantedAuthority> authority = new ArrayList<>();
    	
    	UserDetails userDetails = (UserDetails) new User(login_user.getName(),login_user.getPassword(),authority);
       
    	return userDetails;
    }
}