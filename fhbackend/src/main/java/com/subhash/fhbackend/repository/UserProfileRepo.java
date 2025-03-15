package com.subhash.fhbackend.repository;

import com.subhash.fhbackend.model.User;
import com.subhash.fhbackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileRepo  extends JpaRepository<UserProfile,Long> {
    Optional<UserProfile> findByUser(User user);

    Optional<UserProfile> findByUserId(Long userId);

    List<UserProfile> findByProfession(String developer);

    void deleteByFullName(String email);
}
