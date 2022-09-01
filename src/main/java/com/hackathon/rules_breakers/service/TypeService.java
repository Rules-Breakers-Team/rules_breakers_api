package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Type;
import com.hackathon.rules_breakers.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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

  public String addType(List<Type> type) {
    typeRepository.saveAll(type);
    return "Type successfully added";
  }

  public String changeType(Long id, List<Type> type) {
    boolean exist = typeRepository.findById(id).isPresent();
    Type type1 = new Type();
    for (int i = 0; i < type.size(); i++) {
      if (exist) {
        type1.setName(type.get(i).getName());
        type1.setPrice(type.get(i).getPrice());
        type1.setDescription(type.get(i).getDescription());
      }
      typeRepository.save(type1);
      return "change type successfully";
    }
    return "change type successfully";
  }
}