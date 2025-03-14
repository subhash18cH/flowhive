package com.subhash.fhbackend.controller;

import com.subhash.fhbackend.dto.SwipeRequest;
import com.subhash.fhbackend.model.Swipe;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.service.MatchService;
import com.subhash.fhbackend.service.SwipeService;
import com.subhash.fhbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/swipe")
public class SwipeController {

    @Autowired
    private UserService userService;

    @Autowired
    private SwipeService swipeService;

    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<?>swipeUser(@RequestBody SwipeRequest swipeRequest, Principal principal){
        User currentUser=userService.findByEmail(principal.getName());
        User targetUser=userService.findById(swipeRequest.getTargetUserId());

        if (targetUser == null) {
            return ResponseEntity.badRequest().body("User not found!");
        }
        System.out.println("islIked is"+swipeRequest.getIsLiked());
        Swipe swipe = swipeService.saveSwipe(currentUser, targetUser, swipeRequest.getIsLiked());

        if (swipeRequest.getIsLiked() && swipeService.isMutualLike(currentUser, targetUser)) {
            matchService.createMatch(currentUser, targetUser);
            return ResponseEntity.ok("It's a match!");
        }
        return ResponseEntity.ok("Swipe recorded!");
    }
}
