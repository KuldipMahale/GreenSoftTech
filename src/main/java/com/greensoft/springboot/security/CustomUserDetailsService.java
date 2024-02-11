package com.greensoft.springboot.security;

import com.greensoft.springboot.entity.Users;
import com.greensoft.springboot.exception.NotFoundException;
import com.greensoft.springboot.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepo repo ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.repo.findByUserName(username).orElseThrow(() -> new NotFoundException());

        return user;
    }
}
