package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.model.mapper.RoomMapper;
import com.hackathon.rules_breakers.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/room")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
@Getter
@EqualsAndHashCode
@RestController
public class RoomController {

  private final RoomService roomService;
  private final RoomMapper roomMapper;

  @GetMapping
  public List<Room> getRoom (
          @RequestParam int page,
          @RequestParam int page_size
  ) {
    return roomService.getRoom(page, page_size);
  }
  @PostMapping
  public String addRoom(
          @RequestBody List<com.hackathon.rules_breakers.model.post.Room> room
  ) {
    List<Room> roomList = room.stream().map(roomMapper :: toDomain).toList();
    return roomService.addRoom(roomList);
  }
}
