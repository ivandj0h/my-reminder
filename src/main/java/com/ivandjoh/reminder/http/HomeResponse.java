package com.ivandjoh.reminder.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"message"})
public class HomeResponse {
    @JsonProperty("time")
    private String time;
    @JsonProperty("message")
    private String message;
}
