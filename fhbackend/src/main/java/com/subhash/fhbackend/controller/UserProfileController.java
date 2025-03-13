//package com.subhash.fhbackend.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user/profile")
//public class UserProfileController {
//
//    private UserProfileService userProfileService;
//
//    @Autowired
//    public UserProfileController(UserProfileService userProfileService) {
//        this.userProfileService = userProfileService;
//    }
//
//    @PostMapping("/{userId}/add-info")
//    private UserProfile addInfo(@PathVariable Long userId, @RequestBody UserProfile profile){
//        return userProfileService.save(userId,profile);
//    }
//
//    @GetMapping("/{userId}/profile")
//    public ResponseEntity<UserProfile> getProfile(@PathVariable Long userId) {
//        return ResponseEntity.ok(userProfileService.getProfile(userId));
//    }
//
//}
