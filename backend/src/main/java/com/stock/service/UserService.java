package com.stock.service;


import java.util.List;


//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.stock.model.Authuser;


public interface UserService{
	
    Authuser findUserByEmail(String email);
    Authuser findUserByUserName(String username) throws UsernameNotFoundException;
    void saveUser(Authuser user);
    public void updateUser(Authuser user);


    Authuser findById(Long id);

    public void updatePassword(String newPassword, Authuser user);
  
    
    List<Authuser> getAllUsers();
    
    
}
