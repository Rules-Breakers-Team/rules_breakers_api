package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.Room;
import com.hackathon.rules_breakers.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public List<Room> getAllRooms(
          @RequestParam int page,
          @RequestParam int page_size
  ) {
    return roomService.getAllRooms(page, page_size);
  }
}
