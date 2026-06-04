package com.peterndta.springbootaireviewdemo.controller;

import com.peterndta.springbootaireviewdemo.model.GreetingRequest;
import com.peterndta.springbootaireviewdemo.model.GreetingResponse;
import com.peterndta.springbootaireviewdemo.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "springboot-ai-review-demo");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/greeting")
    public ResponseEntity<GreetingResponse> getGreeting() {
        GreetingRequest request = new GreetingRequest();
        return ResponseEntity.ok(greetingService.generateGreeting(request));
    }

    @PostMapping("/greeting")
    public ResponseEntity<GreetingResponse> createGreeting(@RequestBody GreetingRequest request) {
        return ResponseEntity.ok(greetingService.generateGreeting(request));
    }

    @GetMapping("/greeting/time")
    public ResponseEntity<Map<String, String>> getTimeOfDay() {
        Map<String, String> response = new HashMap<>();
        response.put("timeOfDay", greetingService.determineTimeOfDay());
        return ResponseEntity.ok(response);
    }
}
