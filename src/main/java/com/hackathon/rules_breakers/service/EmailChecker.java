package com.hackathon.rules_breakers.service;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailChecker implements Predicate<String> {
    @Override
    public boolean test(String s){
        return true;
    }
}
