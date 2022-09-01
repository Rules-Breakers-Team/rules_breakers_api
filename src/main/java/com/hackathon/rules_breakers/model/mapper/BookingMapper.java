package com.hackathon.rules_breakers.model.mapper;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.model.rest.Booking;
import com.hackathon.rules_breakers.service.RoomService;
import com.hackathon.rules_breakers.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookingMapper {

  private TypeService typeService;
  private RoomService roomService;

  public Booking toRest(com.hackathon.rules_breakers.model.Booking booking) {
    Booking restBooking = new Booking();
    restBooking.setId(booking.getId());
    restBooking.setClient(booking.getClient());
    restBooking.setPhone_number(booking.getPhone_number());
    restBooking.setRoom_type(booking.getType().getName());
    restBooking.setBookingDate(booking.getBookingDate());
    restBooking.setBookingStart(booking.getBookingStart());
    restBooking.setBookingEnd(booking.getBookingEnd());
    restBooking.setRoom(booking.getRoom());
    return restBooking;
  }

  public com.hackathon.rules_breakers.model.Booking toDomain(com.hackathon.rules_breakers.model.post.Booking toCreate) {
    com.hackathon.rules_breakers.model.Booking domainBooking = new com.hackathon.rules_breakers.model.Booking();
    Type type = typeService.getTypeById(toCreate.getRoomType()).get();
    List<Room> room = roomService.getRoomByTypeAndAvailable(type);
    if (toCreate.getBookingStart().toString().equalsIgnoreCase(toCreate.getBookingDate().toString())) {
      room.get(0).setAvailable(false);
      roomService.updateRoom(room.get(0));
    }
    domainBooking.setClient(toCreate.getClient());
    domainBooking.setPhone_number(toCreate.getPhoneNumber());
    domainBooking.setType(type);
    domainBooking.setBookingDate(toCreate.getBookingDate());
    domainBooking.setBookingStart(toCreate.getBookingStart());
    domainBooking.setBookingEnd(toCreate.getBookingEnd());
    domainBooking.setRoom(room.get(0).getRoomNumber());
    return domainBooking;
  }

  public com.hackathon.rules_breakers.model.Booking toDomain(com.hackathon.rules_breakers.model.put.Booking toUpdate) {
    com.hackathon.rules_breakers.model.Booking domainBooking = new com.hackathon.rules_breakers.model.Booking();
    Type type = typeService.getTypeById(toUpdate.getRoomType()).get();
    List<Room> room = roomService.getRoomByTypeAndAvailable(type);
    if (toUpdate.getBookingDate().toString().equalsIgnoreCase(toUpdate.getBookingStart().toString())) {
      room.get(0).setAvailable(false);
      roomService.updateRoom(room.get(0));
    }
    domainBooking.setId(toUpdate.getId());
    domainBooking.setClient(toUpdate.getClient());
    domainBooking.setPhone_number(toUpdate.getPhoneNumber());
    domainBooking.setType(type);
    domainBooking.setBookingDate(toUpdate.getBookingDate());
    domainBooking.setBookingStart(toUpdate.getBookingStart());
    domainBooking.setBookingEnd(toUpdate.getBookingEnd());
    domainBooking.setRoom(room.get(0).getRoomNumber());
    return domainBooking;
  }
}
