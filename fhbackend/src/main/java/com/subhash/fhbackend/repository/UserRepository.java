package com.subhash.fhbackend.repository;

import com.subhash.fhbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<Object> findByEmail(String email);
}
