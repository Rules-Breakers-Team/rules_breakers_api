package com.hackathon.rules_breakers.repository;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
  @Query("select r from Room r where r.type=:type and r.available=true")
  List<Room> findRoomByTypeAndAvailable(
          @Param("type") Type type);
}
