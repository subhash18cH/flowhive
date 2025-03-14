package com.subhash.fhbackend.service;

import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User findByEmail(String email) {
        Optional<User> user=userRepository.findByEmail(email);
        return user.orElseThrow(()-> new RuntimeException("User not found with Username:"+ email));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
