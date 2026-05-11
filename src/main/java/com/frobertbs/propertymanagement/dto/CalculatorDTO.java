package com.frobertbs.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {
    @JsonProperty("num1")
    private Integer num1;

    @JsonProperty("num2")
    private Integer num2;
}
