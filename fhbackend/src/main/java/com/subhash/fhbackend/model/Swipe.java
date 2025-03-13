package com.subhash.fhbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Swipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUser;

    @ManyToOne
    @JoinColumn(name = "to_user_id", nullable = false)
    private User toUser;

    private boolean isLiked;
}
