package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Booking;
import com.hackathon.rules_breakers.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@AllArgsConstructor
public class BookingService {
  private BookingRepository repository;

  public List<Booking> findAllBooking(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by(DESC, "bookingDate"));
    return repository.findAll(pageable).toList();
  }
}
