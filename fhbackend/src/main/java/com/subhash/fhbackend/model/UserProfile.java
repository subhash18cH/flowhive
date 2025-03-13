package com.subhash.fhbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String profession;
    private String about;
    private String availability;
    private String vision;

    @ElementCollection
    private List<String> skills;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
