package com.hackathon.rules_breakers.model.rest;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Booking {
  private Long id;
  private String client;
  private String phone_number;
  private Date booking_date;
  private String room_type;
}
