package com.my.exness.service;

import com.my.exness.config.UserPrincipal;
import com.my.exness.repository.UserRepo;
import com.my.exness.model.Users;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);
        if(user == null){
            System.out.println("***User not found***");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
