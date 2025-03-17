package com.subhash.fhbackend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserProfileDto {

    private String fullName;
    private String profession;
    private String about;
    private String availability;
    private String vision;
    private List<String> skills;
    private Long userId;
    private LocalDateTime joining;

    public LocalDateTime getJoining() {
        return joining;
    }

    public void setJoining(LocalDateTime joining) {
        this.joining = joining;
    }

    public UserProfileDto(String fullName, String profession, String about, String availability, String vision, List<String> skills, Long userId, LocalDateTime joining) {
        this.fullName = fullName;
        this.profession = profession;
        this.about = about;
        this.availability = availability;
        this.vision = vision;
        this.skills = skills;
        this.userId = userId;
        this.joining = joining;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserProfileDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
