package com.hackathon.rules_breakers.service;

import com.hackathon.rules_breakers.model.Roles;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationForm {
    private final String email;
    private final String password;
    private final Roles roles;
}
