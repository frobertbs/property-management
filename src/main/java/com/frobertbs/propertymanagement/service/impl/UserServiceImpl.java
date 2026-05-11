package com.frobertbs.propertymanagement.service.impl;

import com.frobertbs.propertymanagement.converter.UserConverter;
import com.frobertbs.propertymanagement.dto.UserDTO;
import com.frobertbs.propertymanagement.entity.UserEntity;
import com.frobertbs.propertymanagement.repository.UserRepository;
import com.frobertbs.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // Injections of Dependencies
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userToSave = userConverter.convertUserDTOToUserEntity(userDTO);
        userToSave = userRepository.save(userToSave);
        userDTO = userConverter.convertUserEntityToDTO(userToSave);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
