package com.hackathon.rules_breakers.model.mapper;

import com.hackathon.rules_breakers.model.Room;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoomMapper {
  public Room toDomain(com.hackathon.rules_breakers.model.post.Room toCreate) {
    Room domainType = new Room();
    domainType.setRoom_number(toCreate.getRoom_number());
    domainType.setDescription(toCreate.getDescription());
    domainType.setAvailable(true);
    return domainType;
  }
}
