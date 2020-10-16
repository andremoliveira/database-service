package com.avenuecode.personal.databaseservice.controller;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.resource.UserResource;
import com.avenuecode.personal.databaseservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController implements UserResource {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        UserDTO user = userService.findById(Long.valueOf(id));
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<UserDTO>> getAllUsers() {
        Set<UserDTO> users = userService.listAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        userDTO = userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.deleteUser(Long.valueOf(id)));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable String id) {

        userDTO = userService.updateUser(userDTO, Long.valueOf(id));
        if (userDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}
