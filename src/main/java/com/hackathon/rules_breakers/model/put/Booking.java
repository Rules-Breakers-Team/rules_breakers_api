package com.hackathon.rules_breakers.model.put;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Booking {
  private Long id;
  private String client;
  private String phoneNumber;
  private Long roomType;
  private Date bookingDate;
  private Date bookingStart;
  private Date bookingEnd;
}
