package com.ivandjoh.reminder.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HomeRequest {
    @JsonProperty("time")
    private String time;
}
