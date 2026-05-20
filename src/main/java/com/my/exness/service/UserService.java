package com.my.exness.service;

import com.my.exness.util.JwtUtils;
import com.my.exness.model.Users;
import com.my.exness.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private JwtUtils jwtUtil;

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUserName(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtUtil.generateToken(user.getUserName());
        } else {
            return "User is not authenticated";
        }
    }
}
