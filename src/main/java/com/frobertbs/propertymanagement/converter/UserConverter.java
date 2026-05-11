package com.frobertbs.propertymanagement.converter;

import com.frobertbs.propertymanagement.dto.UserDTO;
import com.frobertbs.propertymanagement.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }

    public UserDTO convertUserEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setPhone(userEntity.getPhone());
        return userDTO;
    }
}
