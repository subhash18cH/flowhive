package com.subhash.fhbackend.controller;

import com.subhash.fhbackend.dto.UserProfileDto;
import com.subhash.fhbackend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/getAll")
public class AllProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/all-profiles")
    public ResponseEntity<List<UserProfileDto>> getAllProfiles(){
        return userProfileService.getAllProfiles();
    }


}
