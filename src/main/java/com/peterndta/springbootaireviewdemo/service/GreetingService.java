package com.peterndta.springbootaireviewdemo.service;

import com.peterndta.springbootaireviewdemo.model.GreetingRequest;
import com.peterndta.springbootaireviewdemo.model.GreetingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final ZoneId VIETNAM_TIMEZONE = ZoneId.of("Asia/Ho_Chi_Minh");

    public GreetingResponse generateGreeting(GreetingRequest request) {
        String message = "Hello!";
        String greetingType = "general";

        if (request.getName() != null && !request.getName().isBlank()) {
            message = "Hello, " + request.getName() + "!";
        }

        if (request.getTimeOfDay() != null && !request.getTimeOfDay().isBlank()) {
            greetingType = request.getTimeOfDay();
        } else {
            greetingType = determineTimeOfDay();
        }

        String timestamp = Instant.now().atZone(VIETNAM_TIMEZONE).format(FORMATTER);

        return GreetingResponse.builder()
                .message(message)
                .timestamp(timestamp)
                .greetingType(greetingType)
                .build();
    }

    public String determineTimeOfDay() {
        Instant now = Instant.now();
        int hour = now.atZone(VIETNAM_TIMEZONE).getHour();

        if (hour >= 5 && hour < 12) {
            return "morning";
        } else if (hour >= 12 && hour < 18) {
            return "afternoon";
        } else if (hour >= 18 && hour < 22) {
            return "evening";
        } else {
            return "night";
        }
    }
}