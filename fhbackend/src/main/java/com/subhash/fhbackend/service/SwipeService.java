package com.subhash.fhbackend.service;

import com.subhash.fhbackend.dto.SwipeDto;
import com.subhash.fhbackend.model.Swipe;
import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.repository.SwipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<SwipeDto> getSentSwipes(Long senderId) {
        List<Swipe> swipes = swipeRepository.findByFromUser(senderId);
        return swipes.stream().map(SwipeDto::fromEntity).collect(Collectors.toList());
    }

    public List<SwipeDto> getReceivedSwipes(Long userId) {
        List<Swipe> swipes = swipeRepository.findByToUser(userId);
        return swipes.stream().map(SwipeDto::toEntity).collect(Collectors.toList());
    }

    public Optional<Swipe> findSwipe(User swiper, User target) {
        return swipeRepository.findByFromUserAndToUser(swiper, target);
    }
}
