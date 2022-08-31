package com.hackathon.rules_breakers.model.mapper;

import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.model.rest.Booking;
import com.hackathon.rules_breakers.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookingMapper {

  private TypeService typeService;
  public Booking toRest(com.hackathon.rules_breakers.model.Booking booking) {
    Booking restBooking = new Booking();
    restBooking.setId(booking.getId());
    restBooking.setClient(booking.getClient());
    restBooking.setPhone_number(booking.getPhone_number());
    restBooking.setRoom_type(booking.getType().getName());
    restBooking.setBooking_date(booking.getBookingDate());
    return restBooking;
  }

  public com.hackathon.rules_breakers.model.Booking toDomain(com.hackathon.rules_breakers.model.post.Booking toCreate) {
    com.hackathon.rules_breakers.model.Booking domainBooking = new com.hackathon.rules_breakers.model.Booking();
    Type type = typeService.getTypeById(toCreate.getRoom_type()).get();
    domainBooking.setClient(toCreate.getClient());
    domainBooking.setPhone_number(toCreate.getPhone_number());
    domainBooking.setType(type);
    domainBooking.setBookingDate(toCreate.getBooking_date());
    return domainBooking;
  }
  public com.hackathon.rules_breakers.model.Booking toDomain(com.hackathon.rules_breakers.model.put.Booking toUpdate) {
    com.hackathon.rules_breakers.model.Booking domainBooking = new com.hackathon.rules_breakers.model.Booking();
    Type type = typeService.getTypeById(toUpdate.getRoom_type()).get();
    domainBooking.setId(toUpdate.getId());
    domainBooking.setClient(toUpdate.getClient());
    domainBooking.setPhone_number(toUpdate.getPhone_number());
    domainBooking.setType(type);
    domainBooking.setBookingDate(toUpdate.getBooking_date());
    return domainBooking;
  }
}
