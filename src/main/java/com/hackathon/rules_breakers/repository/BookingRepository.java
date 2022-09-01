package com.hackathon.rules_breakers.repository;

import com.hackathon.rules_breakers.model.Booking;
import com.hackathon.rules_breakers.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
  List<Booking> findAllByType(Type type);
}
