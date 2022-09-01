package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.mapper.BookingMapper;
import com.hackathon.rules_breakers.model.rest.Booking;
import com.hackathon.rules_breakers.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {
  private BookingService service;
  private BookingMapper mapper;

  @GetMapping
  public List<Booking> getAllBookings(@RequestParam int page, @RequestParam int page_size) {
    return service.findAllBooking(page, page_size).stream().map(mapper::toRest).toList();
  }

  @GetMapping("/types")
  public List<Booking> filterBookingByType(@RequestParam Long id) throws Exception {
    return service.filterBookingByType(id).stream().map(mapper::toRest).toList();
  }

  @PostMapping
  public List<Booking> createBookings(@RequestBody List<com.hackathon.rules_breakers.model.post.Booking> toCreateList) throws Exception {
    List<com.hackathon.rules_breakers.model.Booking> bookingList = toCreateList.stream().map(mapper::toDomain).toList();
    return service.saveAllBooking(bookingList).stream().map(mapper::toRest).toList();
  }

  @PutMapping
  public Booking updateBooking(@RequestBody com.hackathon.rules_breakers.model.put.Booking toUpdate) throws Exception {
    com.hackathon.rules_breakers.model.Booking booking = mapper.toDomain(toUpdate);
    return mapper.toRest(service.updateBooking(booking));
  }
}
