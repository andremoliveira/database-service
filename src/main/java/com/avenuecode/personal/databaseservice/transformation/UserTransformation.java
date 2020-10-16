package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.model.UserEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class UserTransformation {

    private UserTransformation(){}

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static UserEntity toUser(UserDTO userDTO) {

        if(userDTO == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setDateUpdating(userDTO.getDateUpdating());
        userEntity.setDateCreation(userDTO.getDateCreation());
        userEntity.setDateExclusion(userDTO.getDateExclusion());
        userEntity.setId(userDTO.getId());

        return userEntity;
    }

    public static UserDTO toUserDTO(UserEntity userEntity) {

        if(userEntity == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setDateUpdating(userEntity.getDateUpdating());
        userDTO.setDateCreation(userEntity.getDateCreation());
        userDTO.setDateExclusion(userEntity.getDateExclusion());
        userDTO.setId(userEntity.getId());

        return userDTO;

    }

    public static Set<UserDTO> toUserDTOList(Set<UserEntity> userEntities) {

        if(userEntities == null) {
            return null;
        }

        Set<UserDTO> users = new HashSet<>();

        for(UserEntity userEntity : userEntities) {
            users.add(toUserDTO(userEntity));
        }

        return users;
    }

    public static Set<UserEntity> toUserList(Set<UserDTO> users) {

        if(users == null) {
            return null;
        }

        Set<UserEntity> userEntities = new HashSet<>();

        for(UserDTO userDTO : users) {
            userEntities.add(toUser(userDTO));
        }

        return userEntities;
    }

    private static LocalDateTime format(String date) {
        return LocalDateTime.parse(date, formatter);
    }
}
