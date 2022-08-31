package com.hackathon.rules_breakers.repository;

import com.hackathon.rules_breakers.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findUsersByEmailIs(String name);
}
