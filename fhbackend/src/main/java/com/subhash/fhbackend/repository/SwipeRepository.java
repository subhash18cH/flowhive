package com.subhash.fhbackend.repository;

import com.subhash.fhbackend.model.Swipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe,Long> {
}
