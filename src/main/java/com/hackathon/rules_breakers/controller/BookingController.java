package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.mapper.BookingMapper;
import com.hackathon.rules_breakers.model.rest.Booking;
import com.hackathon.rules_breakers.service.BookingService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
@CrossOrigin("http://localhost:8080")
public class BookingController {
  private BookingService service;
  private BookingMapper mapper;

  @GetMapping
  public List<Booking> getAllBookings(@RequestParam int page, @RequestParam int page_size) {
    return service.findAllBooking(page, page_size).stream().map(mapper::toRest).toList();
  }

  @PostMapping
  public List<Booking> createBookings(@RequestBody List<com.hackathon.rules_breakers.model.post.Booking> toCreateList) {
    Twilio.init("AC9f8e7326d9c6d53caedbd808273eacbf",
            "afce33562362ee97a015ae8490d961f0");
    Message.creator(new PhoneNumber(toCreateList.get(0).getPhone_number()), new PhoneNumber("+14248424194"), "Bonjour ," +
            "Votre reservation a ete effectue avec succes . L'equipe NHotel!").create();
    List<com.hackathon.rules_breakers.model.Booking> bookingList = toCreateList.stream().map(mapper::toDomain).toList();
    return service.saveAllBooking(bookingList).stream().map(mapper::toRest).toList();
  }

  @PutMapping
  public Booking updateBooking(@RequestBody com.hackathon.rules_breakers.model.put.Booking toUpdate) throws Exception {
    com.hackathon.rules_breakers.model.Booking booking = mapper.toDomain(toUpdate);
    return mapper.toRest(service.updateBooking(booking));
  }
}
