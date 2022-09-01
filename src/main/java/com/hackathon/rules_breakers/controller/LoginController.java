package com.hackathon.rules_breakers.controller;


import com.hackathon.rules_breakers.model.Users;
import com.hackathon.rules_breakers.service.RegistrationForm;
import com.hackathon.rules_breakers.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@EqualsAndHashCode
public class LoginController {
    private RegistrationService registrationService;

    @PostMapping(value = "/login" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String login(@RequestBody RegistrationForm users) {
        if(users.getPassword()  != registrationService.getPassword(users.getEmail())){
            return "connexion NON faite";
        }
        else {
            registrationService.loadUserByUsername(users.getEmail());
            return "connexion non faite";
        }
    }
}
