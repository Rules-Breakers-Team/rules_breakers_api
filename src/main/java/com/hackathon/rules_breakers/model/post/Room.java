package com.hackathon.rules_breakers.model.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
  private String roomNumber;
  private boolean available = true ;
  private String description;
  private Long type;
}
