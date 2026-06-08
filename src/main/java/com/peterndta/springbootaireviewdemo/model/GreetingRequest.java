// src/main/java/com/peterndta/springbootaireviewdemo/model/GreetingRequest.java
package com.peterndta.springbootaireviewdemo.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GreetingRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @Size(max = 50, message = "Time of day must not exceed 50 characters")
    private String timeOfDay;
}