package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
  private RoomRepository repository;

  public List<Room> getAllRooms(int page, int page_size) {
    Pageable pageable = PageRequest.of(page, page_size);
    return repository.findAll(pageable).toList();
  }

  public List<Room> getRoomByTypeAndAvailable(Type type) {
    return repository.findRoomByTypeAndAvailable(type);
  }

  public Room updateRoom(Room room) {
    return repository.save(room);
  }

  public String addRoom(List<Room> room) {
    repository.saveAll(room);
    return "successfully added";
  }
}