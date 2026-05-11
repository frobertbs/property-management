package com.frobertbs.propertymanagement.service;

import com.frobertbs.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    public List<PropertyDTO> findAllProperties();

    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);

    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);

    public PropertyDTO updatePropertyOwnerName(PropertyDTO propertyDTO, Long propertyId);
}
