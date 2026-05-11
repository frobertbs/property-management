package com.frobertbs.propertymanagement.service.impl;

import com.frobertbs.propertymanagement.converter.PropertyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frobertbs.propertymanagement.dto.PropertyDTO;
import com.frobertbs.propertymanagement.entity.PropertyEntity;
import com.frobertbs.propertymanagement.repository.PropertyRepository;
import com.frobertbs.propertymanagement.service.PropertyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    // Inject the Property Repository
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = propertyConverter.convertPropertyDTOToEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        return propertyConverter.convertPropertyEntityToDTO(propertyEntity);
    }

    @Override
    public List<PropertyDTO> findAllProperties() {

        System.out.println("Inside dev branch I have made a change.");
        List<PropertyEntity> properties = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertiesDTO = new ArrayList<>();
        for (PropertyEntity propertyEntity : properties) {
            propertiesDTO.add(propertyConverter.convertPropertyEntityToDTO(propertyEntity));
        }
        return propertiesDTO;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO updatedProperty = null;

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()){
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());

            propertyRepository.save(propertyEntity);
            updatedProperty = propertyConverter.convertPropertyEntityToDTO(propertyEntity);
            return updatedProperty;
        }

        return updatedProperty;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO result = null;
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
            if(optionalPropertyEntity.isPresent()){
                PropertyEntity propertyEntity = optionalPropertyEntity.get();
                propertyEntity.setDescription(propertyDTO.getDescription());
                result = propertyConverter.convertPropertyEntityToDTO(propertyEntity);
                propertyRepository.save(propertyEntity);
            }

            return result;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO result = null;
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()){
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            result = propertyConverter.convertPropertyEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }

        return result;
    }

    @Override
    public PropertyDTO updatePropertyOwnerName(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO result = null;
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()){
            PropertyEntity propertyEntity = optionalPropertyEntity.get();
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            result = propertyConverter.convertPropertyEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }

        return result;
    }

}


