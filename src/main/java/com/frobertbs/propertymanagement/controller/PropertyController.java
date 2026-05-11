package com.frobertbs.propertymanagement.controller;

import com.frobertbs.propertymanagement.configuration.AppConfig;
import com.frobertbs.propertymanagement.entity.PropertyEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frobertbs.propertymanagement.dto.PropertyDTO;
import com.frobertbs.propertymanagement.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Property Management!";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
       propertyDTO =  propertyService.saveProperty(propertyDTO);
       ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);

       return response;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        // return all properties
        List<PropertyDTO> properties = propertyService.findAllProperties();
        ResponseEntity<List<PropertyDTO>> response = new ResponseEntity<>(properties, HttpStatus.OK);
        return response;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return response;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return response;
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
       propertyDTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return response;
    }

    @PatchMapping("/properties/update-ownerName/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyOwnerName(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO = propertyService.updatePropertyOwnerName(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> response = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
        return response;
    }
}
