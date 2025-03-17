package com.subhash.fhbackend.controller;

import com.subhash.fhbackend.dto.SwipeDto;
import com.subhash.fhbackend.dto.SwipeRequest;
import com.subhash.fhbackend.model.Swipe;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.service.MatchService;
import com.subhash.fhbackend.service.SwipeService;
import com.subhash.fhbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
        Optional<Swipe> existingSwipe = swipeService.findSwipe(currentUser, targetUser);
        if (existingSwipe.isPresent()) {
            return ResponseEntity.badRequest().body("You have already swiped on this user!");
        }

        Swipe swipe = swipeService.saveSwipe(currentUser, targetUser, swipeRequest.getIsLiked());
        if (swipeRequest.getIsLiked() && swipeService.isMutualLike(currentUser, targetUser)) {
            matchService.createMatch(currentUser, targetUser);
            return ResponseEntity.ok("It's a match!");
        }
        return ResponseEntity.ok("Swipe recorded!");
    }

    @GetMapping("/sent")
    public ResponseEntity<List<SwipeDto>> getSentSwipes(Principal principal) {
        User currentUser=userService.findByEmail(principal.getName());
        Long userId=currentUser.getId();
        return ResponseEntity.ok(swipeService.getSentSwipes(userId));
    }

    @GetMapping("/received")
    public ResponseEntity<List<SwipeDto>> getReceivedSwipes(Principal principal) {
        User currentUser=userService.findByEmail(principal.getName());
        Long userId=currentUser.getId();
        return ResponseEntity.ok(swipeService.getReceivedSwipes(userId));
    }
}
