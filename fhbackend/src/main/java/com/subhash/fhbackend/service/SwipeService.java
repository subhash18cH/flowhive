package com.subhash.fhbackend.service;

import com.subhash.fhbackend.model.Swipe;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.repository.SwipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwipeService {

    @Autowired
    private SwipeRepository swipeRepository;

    public Swipe saveSwipe(User currentUser, User targetUser, boolean isLiked) {
        Swipe swipe = new Swipe();
        swipe.setFromUser(currentUser);
        swipe.setToUser(targetUser);
        swipe.setLiked(isLiked);
        return swipeRepository.save(swipe);
    }

    public boolean isMutualLike(User currentUser, User targetUser) {
        return swipeRepository.existsByFromUserAndToUserAndIsLiked(currentUser, targetUser, true);
    }
}
