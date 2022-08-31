package com.hackathon.rules_breakers.model.mapper;

import com.hackathon.rules_breakers.model.Type;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TypeMapper {

  public Type toDomain(com.hackathon.rules_breakers.model.post.Type toCreate) {
    Type domainType = new Type();
    domainType.setName(toCreate.getName());
    domainType.setDescription(toCreate.getDescription());
    domainType.setPrice(toCreate.getPrice());
    return domainType;
  }
}
