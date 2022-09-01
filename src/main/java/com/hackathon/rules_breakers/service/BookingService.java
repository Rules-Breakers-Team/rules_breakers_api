package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Booking;
import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.repository.BookingRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@AllArgsConstructor
public class BookingService {
  private BookingRepository repository;

  private TypeService typeService;

  public List<Booking> findAllBooking(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page, pageSize, Sort.by(DESC, "bookingDate"));
    return repository.findAll(pageable).toList();
  }

  @Transactional
  public List<Booking> saveAllBooking(List<Booking> toCreate) throws Exception {
    if (toCreate.get(0).getRoom() != null) {
      Twilio.init("ACb0569ff2899c45d39ed10c42bc6741c1",
              "9f443f1688388aa645c04fdb5970707c");
      Message.creator(new PhoneNumber(toCreate.get(0).getPhone_number()), new PhoneNumber("+15626627451"), "Bonjour ," +
              "Votre reservation a ete effectue avec succes . L'equipe NHotel!").create();
      return repository.saveAll(toCreate);
    } else {
      throw new Exception("Il n'y a plus de chambres disponibles " +
              "pour cette date, veuillez saisir une date ulterieur");
    }
  }

  public Booking updateBooking(Booking toUpdate) throws Exception {
    if (toUpdate.getRoom() != null) {
      return repository.save(toUpdate);
    } else {
      throw new Exception("Il n'y a plus de chambre disponible " +
              "pour cette date, veuillez saisir une date ulterieur");
    }
  }

  public List<Booking> filterBookingByType(Long typeId) throws Exception {
    Optional<Type> type = typeService.getTypeById(typeId);
    if (type.isPresent()) {
      return repository.findAllByType(type.get());
    } else {
      throw new Exception();
    }
  }
}
