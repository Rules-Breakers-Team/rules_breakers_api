package com.hackathon.rules_breakers.model.mapper;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RoomMapper {
  private TypeService typeService;
  public Room toDomain(com.hackathon.rules_breakers.model.post.Room toCreate) {
    Room domainType = new Room();
    Optional<Type> type = typeService.getTypeById(toCreate.getType());
    domainType.setRoomNumber(toCreate.getRoomNumber());
    domainType.setDescription(toCreate.getDescription());
    domainType.setAvailable(true);
    domainType.setType(type.get());
    return domainType;
  }
  public Room toDomain(com.hackathon.rules_breakers.model.put.Room toUpdate) {
    Room domainType = new Room();
    Optional<Type> type = typeService.getTypeById(toUpdate.getType());
    domainType.setRoomNumber(toUpdate.getRoomNumber());
    domainType.setDescription(toUpdate.getDescription());
    domainType.setAvailable(true);
    domainType.setType(type.get());
    return domainType;
  }
}
