package com.frobertbs.propertymanagement.service;

import com.frobertbs.propertymanagement.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);
    UserDTO login(String email, String password);
}
