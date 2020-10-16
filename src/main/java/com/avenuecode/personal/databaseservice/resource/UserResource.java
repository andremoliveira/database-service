package com.avenuecode.personal.databaseservice.resource;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/database-service/v1")
@Api(value = "User")
public interface UserResource {

    @ApiOperation(value = "Descricao legal")
    @GetMapping("/user/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable String id);

    @GetMapping("/user")
    ResponseEntity<Set<UserDTO>> getAllUsers();

    @PostMapping("/user")
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);

    @DeleteMapping("/user/{id}")
    ResponseEntity<String> deleteUser(@PathVariable String id);

    @PutMapping("/user/{id}")
    ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable String id);
}
