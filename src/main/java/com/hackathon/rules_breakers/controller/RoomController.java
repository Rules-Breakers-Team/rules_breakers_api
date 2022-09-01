package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.mapper.RoomMapper;
import com.hackathon.rules_breakers.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rooms")
@CrossOrigin("*")
public class RoomController {
  private RoomService roomService;
  private RoomMapper roomMapper;

  @GetMapping
  public List<Room> getAllRooms(
          @RequestParam int page,
          @RequestParam int page_size
  ) {
    return roomService.getAllRooms(page, page_size);
  }


  @PostMapping
  public String addRoom(
          @RequestBody List<com.hackathon.rules_breakers.model.post.Room> room
  ) {
    List<Room> roomList = room.stream().map(roomMapper::toDomain).toList();
    return roomService.addRoom(roomList);
  }

  @PutMapping
  public Room updateRoom(@RequestBody com.hackathon.rules_breakers.model.put.Room toUpdate) {
    Room room = roomMapper.toDomain(toUpdate);
    return roomService.updateRoom(room);
  }
}