package com.hackathon.rules_breakers.model.put;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
  private Long id;
  private String roomNumber;
  private boolean available = true ;
  private String description;
  private Long type;
}
