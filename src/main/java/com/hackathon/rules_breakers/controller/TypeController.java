package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.model.mapper.TypeMapper;
import com.hackathon.rules_breakers.service.TypeService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/types")
@AllArgsConstructor
@CrossOrigin("*")
@Getter
@EqualsAndHashCode
@RestController
public class TypeController {
  private final TypeService typeService;
  private final TypeMapper typeMapper;

  @GetMapping
  public List<Type> getType(
          @RequestParam int page,
          @RequestParam int page_size
          ) throws IllegalArgumentException {
    return typeService.getType(page,page_size);
  }

  @GetMapping("/{id}")
  public Optional<Type> getTypeById(
          @PathVariable Long id
  ){
    return typeService.getTypeById(id);
  }

  @PostMapping
  public String addType(@RequestBody List<com.hackathon.rules_breakers.model.post.Type> type){
    List<Type> typeList = type.stream().map(typeMapper :: toDomain).toList();
    return typeService.addType(typeList);
  }

  @PutMapping
  public Type updateType(@RequestBody com.hackathon.rules_breakers.model.put.Type toUpdate) {
    Type type = typeMapper.toDomain(toUpdate);
    return typeService.updateType(type);
  }
}
