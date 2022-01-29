package com.alkemy.disney.disney.auth.service;

import com.alkemy.disney.disney.auth.entity.User;
import com.alkemy.disney.disney.auth.repository.UserRepository;
import com.alkemy.disney.disney.auth.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User entity = userRepository.findByUsername(userName);
        if(entity == null) {
            throw new UsernameNotFoundException("username or password not found");
        }
        return new org.springframework.security.core.userdetails.User(entity.getUsername(), entity.getPassword(), Collections.emptyList());
    }

    public boolean save(UserDTO dto){
        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity = this.userRepository.save(entity);
        if(entity != null){
            emailService.sendWelcomeEmailTo(entity.getUsername());
        }
        return entity != null;
    }
}
