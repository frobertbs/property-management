package com.frobertbs.propertymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frobertbs.propertymanagement.dto.CalculatorDTO;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {
    @GetMapping("/add")
    public int add(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return a + b;
    }

    @GetMapping("/substract")
    public int substract(@RequestParam("num1") int a, @RequestParam("num2") int b){
        if(a > b){
            return a - b;
        }
        return 0;
    }

    @GetMapping("/multiply")
    public Double multiply(@RequestParam("num1") Double a, @RequestParam("num2") Double b){
        return a * b;
    }

    @GetMapping("/divide/{num1}/{num2}")
    public Double divide(@PathVariable("num1") Double a, @PathVariable("num2") Double b){
        return a / b;
    }

    @PostMapping("/modulus")
    public ResponseEntity<Integer> modulus(@RequestBody CalculatorDTO calculator){
        Integer result = calculator.getNum1() % calculator.getNum2();
        ResponseEntity<Integer> response;
        if(result == 0){
            response = new ResponseEntity(result, HttpStatus.OK);
        }else{
            response = new ResponseEntity(result, HttpStatus.CREATED);
        }
        return response;
    }
}
