package com.hackathon.rules_breakers.model.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
  private Long room_number;
  private boolean available = true ;
  private String description;
}
