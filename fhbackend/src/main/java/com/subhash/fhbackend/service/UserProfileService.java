package com.subhash.fhbackend.service;

import com.subhash.fhbackend.dto.UserProfileDto;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.model.UserProfile;
import com.subhash.fhbackend.repository.UserProfileRepo;
import com.subhash.fhbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Autowired
    private UserRepository userRepo;

    public void save(Long userId, UserProfile profile) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfile userProfile = userProfileRepo.findByUser(user).orElse(new UserProfile());
        userProfile.setUser(user);
        userProfile.setFullName(profile.getFullName());
        userProfile.setAbout(profile.getAbout());
        userProfile.setSkills(profile.getSkills());
        userProfile.setVision(profile.getVision());
        userProfile.setProfession(profile.getProfession());
        userProfile.setAvailability(profile.getAvailability());
        userProfileRepo.save(userProfile);
    }

    public UserProfileDto getProfile(Long userId) {
        UserProfile userProfile= userProfileRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        UserProfileDto userProfileDto=new UserProfileDto();
        userProfileDto.setFullName(userProfile.getFullName());
        userProfileDto.setAbout(userProfile.getAbout());
        userProfileDto.setAvailability(userProfile.getAvailability());
        userProfileDto.setProfession(userProfile.getProfession());
        userProfileDto.setVision(userProfile.getVision());
        userProfileDto.setSkills(userProfile.getSkills());
        return userProfileDto;
    }
}
