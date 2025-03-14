package com.subhash.fhbackend.dto;

import java.util.List;

public class UserProfileDto {

    private String fullName;
    private String profession;
    private String about;
    private String availability;
    private String vision;
    private List<String> skills;

    public UserProfileDto(String fullName, List<String> skills, String vision, String availability, String about, String profession) {
        this.fullName = fullName;
        this.skills = skills;
        this.vision = vision;
        this.availability = availability;
        this.about = about;
        this.profession = profession;
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
