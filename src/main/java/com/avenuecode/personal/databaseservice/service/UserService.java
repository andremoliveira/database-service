package com.avenuecode.personal.databaseservice.service;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.model.UserEntity;
import com.avenuecode.personal.databaseservice.repository.UserRepository;
import com.avenuecode.personal.databaseservice.transformation.UserTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        userDTO.setDateCreation(LocalDateTime.now());
        userDTO.setDateUpdating(LocalDateTime.now());
        return UserTransformation.toUserDTO(userRepository.save(UserTransformation.toUser(userDTO)));
    }

    public UserDTO findById(Long id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);

        if(!userEntity.isPresent())
            return null;

        return UserTransformation.toUserDTO(userEntity.get());
    }

    public Set<UserDTO> listAll() {
        Set<UserEntity> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return UserTransformation.toUserDTOList(users);
    }

    public HttpStatus deleteUser(Long userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        }
            return HttpStatus.NO_CONTENT;
    }

    //TODO check how to update user
    public UserDTO updateUser(UserDTO userDTO, Long id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);

        if(!userEntity.isPresent())
            return null;

        userDTO.setId(id);
        userDTO.setDateUpdating(LocalDateTime.now());
        userDTO.setDateCreation(userEntity.get().getDateCreation());
        return UserTransformation.toUserDTO(userRepository.save(UserTransformation.toUser(userDTO)));

    }

}
