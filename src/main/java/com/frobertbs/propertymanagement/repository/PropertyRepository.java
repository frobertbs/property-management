package com.frobertbs.propertymanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.frobertbs.propertymanagement.entity.PropertyEntity;

import java.util.Optional;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

    Optional<PropertyEntity> findById(Long id);
    
}
