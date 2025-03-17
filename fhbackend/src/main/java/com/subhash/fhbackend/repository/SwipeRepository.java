package com.subhash.fhbackend.repository;

import com.subhash.fhbackend.model.Swipe;
import com.subhash.fhbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe,Long> {
    boolean existsByFromUserAndToUserAndIsLiked(User currentUser, User targetUser, boolean isLiked);

    @Query("SELECT s FROM Swipe s WHERE s.fromUser.id = :userId")
    List<Swipe> findByFromUser(@Param("userId") Long senderId);


    @Query("SELECT s FROM Swipe s WHERE s.toUser.id = :userId")
    List<Swipe> findByToUser(@Param("userId") Long userId);

    Optional<Swipe> findByFromUserAndToUser(User swiper, User target);
}
