package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.mapper.BookingMapper;
import com.hackathon.rules_breakers.model.rest.Booking;
import com.hackathon.rules_breakers.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
@CrossOrigin("http://localhost:8080")
public class BookingController {
  private BookingService service;
  private BookingMapper mapper;

  @GetMapping
  public List<Booking> getAllBooking(
          @RequestParam int page,
          @RequestParam int page_size
  ) {
    return service.findAllBooking(page, page_size).stream()
            .map(mapper::toRest).toList();
  }
}
