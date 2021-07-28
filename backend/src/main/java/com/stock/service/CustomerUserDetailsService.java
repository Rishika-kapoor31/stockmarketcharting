package com.stock.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.UserDao;
import com.stock.model.Authuser;

@Service
@Transactional
public class CustomerUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDao userDao;
    
    private static Collection<? extends GrantedAuthority> getAuthorities (Authuser user) {
    	Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getUserType().name()));
        return authorities;
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
        Authuser user = userDao.findByUsername(username);
        if (user == null) {
        	throw new UsernameNotFoundException("No user found with username: " + username);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        
        return new org.springframework.security.core.userdetails.User(
          user.getUsername(), user.getPassword(), enabled, accountNonExpired,
          credentialsNonExpired, accountNonLocked, getAuthority(user));
    }
    
    private Set getAuthority(Authuser user) {
        Set authorities = new HashSet<>();

            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getUserType().name()));

		return authorities;
	}
    

}
