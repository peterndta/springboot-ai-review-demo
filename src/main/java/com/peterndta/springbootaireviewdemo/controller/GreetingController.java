package com.peterndta.springbootaireviewdemo.controller;

import com.peterndta.springbootaireviewdemo.model.GreetingRequest;
import com.peterndta.springbootaireviewdemo.model.GreetingResponse;
import com.peterndta.springbootaireviewdemo.service.GreetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @PostMapping
    public ResponseEntity<GreetingResponse> postGreeting(@RequestBody @Valid GreetingRequest request) {
        GreetingResponse response = greetingService.generateGreeting(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GreetingResponse> getGreeting() {
        // For GET requests, we create a minimal request with null values
        GreetingRequest request = new GreetingRequest();
        GreetingResponse response = greetingService.generateGreeting(request);
        return ResponseEntity.ok(response);
    }
}