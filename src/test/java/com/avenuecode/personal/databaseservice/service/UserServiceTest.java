package com.avenuecode.personal.databaseservice.service;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.repository.UserRepository;
import com.avenuecode.personal.databaseservice.transformation.UserTransformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleUserDto;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleUserList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setUp() {
        this.userService = new UserService(userRepository);
    }

    @Test
    public void saveUser_withValidValues_shouldReturnUserDto() {
        when(userRepository.save(any())).thenReturn(UserTransformation.toUser(getSampleUserDto(true, 1L)));
        UserDTO response = userService.saveUser(getSampleUserDto(false, null));

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    public void findById_withValidValues_shouldReturnUserDto() {
        when(userRepository.findById(any())).thenReturn(Optional.of(UserTransformation.toUser(getSampleUserDto(true, 1L))));
        UserDTO response = userService.findById(1L);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    public void findById_withValidValuesButNotFound_shouldReturnNull() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        UserDTO response = userService.findById(1L);

        assertThat(response).isNull();
    }

    @Test
    public void listAll_withValidValues_shouldReturnListOfUser() {
        when(userRepository.findAll()).thenReturn(getSampleUserList());
        Set<UserDTO> response = userService.listAll();

        assertThat(response).isNotNull();
        assertThat(response.size()).isEqualTo(2);
    }

    @Test
    public void deleteUser_withValidValues_shouldReturnNoContent() {
        doNothing().when(userRepository).deleteById(any());
        HttpStatus response = userService.deleteUser(1L);

        assertThat(response).isNotNull();
        assertThat(response.value()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void deleteUser_withNonExistentUser_shouldReturnNotFound() {
        doThrow(new EmptyResultDataAccessException(0)).when(userRepository).deleteById(any());
        HttpStatus response = userService.deleteUser(1L);

        assertThat(response).isNotNull();
        assertThat(response.value()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void updateUser_withValidValues_shouldReturnListOfUser() {
        UserDTO userDTO = getSampleUserDto(false, 1L);
        userDTO.setEmail("anotherEmail@email.com");
        userDTO.setId(1L);
        when(userRepository.findById(any())).thenReturn(Optional.of(UserTransformation.toUser(getSampleUserDto(true, 1L))));
        when(userRepository.save(any())).thenReturn(UserTransformation.toUser(userDTO));

        UserDTO response = userService.updateUser(userDTO, 1L);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getEmail()).isEqualTo("anotherEmail@email.com");
    }

    @Test
    public void updateUser_withNonExistentUser_shouldReturnNull() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        UserDTO response = userService.updateUser(getSampleUserDto(false, null), 1L);

        assertThat(response).isNull();
    }
}
