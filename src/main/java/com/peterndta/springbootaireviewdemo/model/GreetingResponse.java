package com.peterndta.springbootaireviewdemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GreetingResponse {
    private String message;
    private String timestamp;
    private String greetingType;
}