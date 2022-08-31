package com.hackathon.rules_breakers.model.put;

import lombok.Getter;
import lombok.Setter;
import com.twilio.Twilio;
import java.util.Date;

@Getter
@Setter
public class Booking {
  private Long id;
  private String client;
  private String phone_number;
  private Long room_type;
  private Date booking_date;
}
