package com.subhash.fhbackend.service;

import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.model.UserProfile;
import com.subhash.fhbackend.repository.UserProfileRepo;
import com.subhash.fhbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserProfileRepo userProfileRepo;
    private UserRepository userRepo;

    @Autowired
    public UserProfileService(UserProfileRepo userProfileRepo) {
        this.userProfileRepo = userProfileRepo;
        this.userRepo = userRepo;
    }

    public UserProfile save(Long userId, UserProfile profile) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfile userProfile = userProfileRepo.findByUser(user).orElse(new UserProfile());
        profile.setUser(user);
        profile.setFullName(profile.getFullName());
        profile.setAbout(profile.getAbout());
        profile.setSkills(profile.getSkills());
        profile.setVision(profile.getVision());
        profile.setProfession(profile.getProfession());
        profile.setAvailability(profile.getAvailability());
        return userProfileRepo.save(profile);
    }

    public UserProfile getProfile(Long userId) {
        return userProfileRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
