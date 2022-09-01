package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import static org.springframework.data.domain.Sort.Direction.DESC;
@Service
@AllArgsConstructor
public class RoomService {
  private  final RoomRepository roomRepository;

  public List<Room> getRoom(int page , int page_size){
    Pageable pageable = PageRequest.of(page, page_size, Sort.by(DESC, "roomNumber"));
  return roomRepository.findAll(pageable).toList();
  }
  public String addRoom(List<Room> room) {
    roomRepository.saveAll(room);
    return "successfully added";
  }
  public List<Room> getRoomByTypeAndAvailable(Type type){
    return roomRepository.findRoomByTypeAndAvailable(type);
  }

  public Room updateRoom(Room room){
    return roomRepository.save(room);
  }
}
