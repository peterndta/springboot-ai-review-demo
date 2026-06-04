package com.peterndta.springbootaireviewdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GreetingResponse {
    private String message;
    private String timestamp;
    private String greetingType;
}
