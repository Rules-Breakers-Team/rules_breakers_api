package com.hackathon.rules_breakers.repository;

import com.hackathon.rules_breakers.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room , Long> {
}
