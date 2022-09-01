package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@AllArgsConstructor
public class TypeService {
  private final TypeRepository typeRepository;

  public List<Type> getType(int page, int page_size) {
    Pageable pageable = PageRequest.of(page, page_size, Sort.by(DESC, "price"));
    return typeRepository.findAll(pageable).toList();
  }

  public Optional<Type> getTypeById(Long id) {
    return typeRepository.findById(id);
  }

  @Transactional
  public String addType(List<Type> type) {
    typeRepository.saveAll(type);
    return "Type successfully added";
  }

  public Type updateType(Type toUpdate) {
    return typeRepository.save(toUpdate);

  }
}
