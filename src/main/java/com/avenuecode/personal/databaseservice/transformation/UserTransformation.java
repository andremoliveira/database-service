package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.model.UserEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.HashSet;
import java.util.Set;

public class UserTransformation {

    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private UserTransformation(){}

    public static UserEntity toUser(UserDTO userDTO) {

        if(userDTO == null) {
            return null;
        }

        BoundMapperFacade<UserDTO, UserEntity> boundMapperFacade = mapperFactory.getMapperFacade(UserDTO.class, UserEntity.class);
        return boundMapperFacade.map(userDTO);
    }

    public static UserDTO toUserDTO(UserEntity userEntity) {

        if(userEntity == null) {
            return null;
        }

        BoundMapperFacade<UserEntity, UserDTO> boundMapperFacade = mapperFactory.getMapperFacade(UserEntity.class, UserDTO.class);
        return boundMapperFacade.map(userEntity);
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

}
