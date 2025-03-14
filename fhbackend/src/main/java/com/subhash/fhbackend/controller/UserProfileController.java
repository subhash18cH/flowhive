package com.subhash.fhbackend.controller;

import com.subhash.fhbackend.dto.UserProfileDto;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.model.UserProfile;
import com.subhash.fhbackend.service.UserProfileService;
import com.subhash.fhbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserService userService;

    @PostMapping("/add-info")
    private String addInfo(@RequestBody UserProfile profile, Principal principal){
        User user=userService.findByEmail(principal.getName());
        Long userId=user.getId();
        userProfileService.save(userId,profile);
        return "user profile created successfully!";
    }

    @GetMapping()
    public ResponseEntity<UserProfileDto> getProfile( Principal principal) {
        User user=userService.findByEmail(principal.getName());
        Long userId=user.getId();
        return ResponseEntity.ok(userProfileService.getProfile(userId));
    }
}
