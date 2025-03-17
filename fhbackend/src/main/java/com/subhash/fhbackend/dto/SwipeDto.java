package com.subhash.fhbackend.dto;

import com.subhash.fhbackend.model.Swipe;

import java.time.LocalDateTime;

public class SwipeDto {

    private LocalDateTime joining;
    private String fullName;
    private String profession;
    private Long profileId;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public LocalDateTime getJoining() {
        return joining;
    }

    public void setJoining(LocalDateTime joining) {
        this.joining = joining;
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

    public SwipeDto(LocalDateTime joining, String fullName, String profession, Long profileId) {
        this.joining = joining;
        this.fullName = fullName;
        this.profession = profession;
        this.profileId = profileId;
    }

    public SwipeDto() {
    }

    public static SwipeDto fromEntity(Swipe swipe) {
        return new SwipeDto(
                swipe.getToUser().getProfile().getJoining(),
                swipe.getToUser().getProfile().getFullName(),
                swipe.getToUser().getProfile().getProfession(),
                swipe.getToUser().getId()

        );
    }

    public static SwipeDto toEntity(Swipe swipe) {
        return new SwipeDto(
                swipe.getFromUser().getProfile().getJoining(),
                swipe.getFromUser().getProfile().getFullName(),
                swipe.getFromUser().getProfile().getProfession(),
                swipe.getFromUser().getId()

        );
    }
}
