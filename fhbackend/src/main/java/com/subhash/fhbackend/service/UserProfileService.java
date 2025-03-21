package com.subhash.fhbackend.service;

import com.subhash.fhbackend.dto.UserProfileDto;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.model.UserProfile;
import com.subhash.fhbackend.repository.UserProfileRepo;
import com.subhash.fhbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
        userProfile.setJoining(LocalDateTime.now());
        userProfileRepo.save(userProfile);
    }

    public UserProfileDto getProfile(Long userId)
    {
        UserProfile userProfile= userProfileRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        UserProfileDto userProfileDto=new UserProfileDto();
        userProfileDto.setFullName(userProfile.getFullName());
        userProfileDto.setAbout(userProfile.getAbout());
        userProfileDto.setAvailability(userProfile.getAvailability());
        userProfileDto.setProfession(userProfile.getProfession());
        userProfileDto.setVision(userProfile.getVision());
        userProfileDto.setSkills(userProfile.getSkills());
        userProfileDto.setUserId(userProfile.getUser().getId());
        userProfileDto.setJoining(userProfile.getJoining());
        return userProfileDto;
    }

    public ResponseEntity<List<UserProfileDto>> getAllProfiles() {
        List<UserProfile> userProfiles=userProfileRepo.findAll();
        List<UserProfileDto> userProfileDtos = userProfiles.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userProfileDtos);
    }


    public ResponseEntity<List<UserProfileDto>> getAllDevelopers(Long userId) {
        List<UserProfile>developers=userProfileRepo.findByProfession("Developer").stream()
                .filter(userProfile->!userProfile.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        List<UserProfileDto> developerDtos = developers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(developerDtos);
    }

    public ResponseEntity<List<UserProfileDto>> getAllMarketers(Long userId) {
        List<UserProfile>marketers =userProfileRepo.findByProfession("Marketer").stream()
                .filter(userProfile->!userProfile.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        List<UserProfileDto> marketerDtos = marketers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(marketerDtos );
    }

    public void deleteProfile(Long id) {
        userRepo.deleteById(id);
    }


    public ResponseEntity<UserProfileDto> updateProfile(Long userId, UserProfileDto userProfileDto) {
        UserProfile userProfile=userProfileRepo.findByUserId(userId).orElseThrow(()-> new RuntimeException("User Profile not found"));
        userProfile.setFullName(userProfileDto.getFullName());
        userProfile.setProfession(userProfileDto.getProfession());
        userProfile.setAbout(userProfileDto.getAbout());
        userProfile.setAvailability(userProfileDto.getAvailability());
        userProfile.setVision(userProfileDto.getVision());
        userProfile.setSkills(userProfileDto.getSkills());
        UserProfile updatedProfile = userProfileRepo.save(userProfile);
        return ResponseEntity.ok( convertToDto(updatedProfile));
    }

    private UserProfileDto convertToDto(UserProfile userProfile) {
        return new UserProfileDto(
                userProfile.getFullName(),
                userProfile.getProfession(),
                userProfile.getAbout(),
                userProfile.getAvailability(),
                userProfile.getVision(),
                userProfile.getSkills(),
                userProfile.getUser().getId(),
                userProfile.getJoining()
        );
    }

    public UserProfileDto getProfileById(Long profileId) {
        UserProfile userProfile= userProfileRepo.findByUserId(profileId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));;
        UserProfileDto userProfileDto=new UserProfileDto();
        userProfileDto.setFullName(userProfile.getFullName());
        userProfileDto.setAbout(userProfile.getAbout());
        userProfileDto.setAvailability(userProfile.getAvailability());
        userProfileDto.setProfession(userProfile.getProfession());
        userProfileDto.setVision(userProfile.getVision());
        userProfileDto.setSkills(userProfile.getSkills());
        userProfileDto.setUserId(userProfile.getUser().getId());
        userProfileDto.setJoining(userProfile.getJoining());
        return userProfileDto;
    }
}
