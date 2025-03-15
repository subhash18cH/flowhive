package com.subhash.fhbackend.controller;

import com.subhash.fhbackend.dto.UserProfileDto;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.model.UserProfile;
import com.subhash.fhbackend.service.UserProfileService;
import com.subhash.fhbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

    @GetMapping("/developers")
    public ResponseEntity<List<UserProfileDto>> getAllDevelopers(){
        return userProfileService.getAllDevelopers();
    }

    @GetMapping("/marketers")
    public ResponseEntity<List<UserProfileDto>> getAllMarketers(){
        return userProfileService.getAllMarketers();
    }

    @DeleteMapping
    public void deleteProfile(Principal principal){
        User user=userService.findByEmail(principal.getName());
        userProfileService.deleteProfile(user.getId());
    }

    @PutMapping
    public ResponseEntity<UserProfileDto> updateProfile( Principal principal,@RequestBody UserProfileDto userProfileDto) {
        User user=userService.findByEmail(principal.getName());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
       return userProfileService.updateProfile(user.getId(), userProfileDto);
    }
}
