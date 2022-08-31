package com.hackathon.rules_breakers.model.mapper;

import com.hackathon.rules_breakers.model.rest.Booking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookingMapper {
  public Booking toRest(com.hackathon.rules_breakers.model.Booking booking){
    Booking restBooking = new Booking();
    restBooking.setId(booking.getId());
    restBooking.setClient(booking.getClient());
    restBooking.setPhone_number(booking.getPhone_number());
    restBooking.setRoom_type(booking.getType().getName());
    restBooking.setBooking_date(booking.getBookingDate());
    return restBooking;
  }
}
