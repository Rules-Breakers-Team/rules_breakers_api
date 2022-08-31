package com.hackathon.rules_breakers.model.post;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Booking {
  private String client;
  private String phone_number;
  private Long room_type;
  private Date booking_date;
}
