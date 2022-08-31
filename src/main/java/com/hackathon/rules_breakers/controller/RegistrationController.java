package com.hackathon.rules_breakers.controller;

import com.hackathon.rules_breakers.model.Users;
import com.hackathon.rules_breakers.service.RegistrationForm;
import com.hackathon.rules_breakers.service.RegistrationService;
import com.hackathon.rules_breakers.service.UsersRegistration;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
public class RegistrationController {
    private UsersRegistration usersRegistration;
    @PostMapping(value = "/signup" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody RegistrationForm request) {
        return usersRegistration.register(request);
    }
}