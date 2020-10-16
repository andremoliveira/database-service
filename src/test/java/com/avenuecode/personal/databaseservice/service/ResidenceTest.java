package com.avenuecode.personal.databaseservice.service;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.repository.ResidenceRepository;
import com.avenuecode.personal.databaseservice.transformation.ResidenceTransformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleResidenceDto;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleResidenceList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ResidenceTest {

    @MockBean
    private ResidenceRepository residenceRepository;

    private ResidenceService residenceService;

    @Before
    public void setUp() {
        this.residenceService = new ResidenceService(residenceRepository);
    }

    @Test
    public void saveResidence_withValidValues_shouldReturnResidenceDto() {
        when(residenceRepository.save(any())).thenReturn(ResidenceTransformation.toResidence(getSampleResidenceDto(true, 1L)));
        ResidenceDTO response = residenceService.saveResidence(getSampleResidenceDto(false, null));

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    public void findById_withValidValues_shouldReturnUserDto() {
        when(residenceRepository.findById(any())).thenReturn(Optional.of(ResidenceTransformation.toResidence(getSampleResidenceDto(true, 1L))));
        ResidenceDTO response = residenceService.findById(1L);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    public void findById_withValidValuesButNotFound_shouldReturnNull() {
        when(residenceRepository.findById(any())).thenReturn(Optional.empty());
        ResidenceDTO response = residenceService.findById(1L);

        assertThat(response).isNull();
    }

    @Test
    public void listAll_withValidValues_shouldReturnListOfUser() {
        when(residenceRepository.findAll()).thenReturn(getSampleResidenceList());
        Set<ResidenceDTO> response = residenceService.listAll();

        assertThat(response).isNotNull();
        assertThat(response.size()).isEqualTo(2);
    }

    @Test
    public void deleteUser_withValidValues_shouldReturnNoContent() {
        doNothing().when(residenceRepository).deleteById(any());
        HttpStatus response = residenceService.deleteResidence(1L);

        assertThat(response).isNotNull();
        assertThat(response.value()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void deleteUser_withNonExistentUser_shouldReturnNotFound() {
        doThrow(new EmptyResultDataAccessException(0)).when(residenceRepository).deleteById(any());
        HttpStatus response = residenceService.deleteResidence(1L);

        assertThat(response).isNotNull();
        assertThat(response.value()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    public void updateUser_withValidValues_shouldReturnListOfUser() {
        ResidenceDTO residenceDto = getSampleResidenceDto(false, 1L);
        residenceDto.setAddress("another address");
        residenceDto.setId(1L);
        when(residenceRepository.findById(any())).thenReturn(Optional.of(ResidenceTransformation.toResidence(getSampleResidenceDto(true, 1L))));
        when(residenceRepository.save(any())).thenReturn(ResidenceTransformation.toResidence(residenceDto));

        ResidenceDTO response = residenceService.updateResidence(residenceDto, 1L);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getAddress()).isEqualTo("another address");
    }

    @Test
    public void updateUser_withNonExistentUser_shouldReturnNull() {
        when(residenceRepository.findById(any())).thenReturn(Optional.empty());
        ResidenceDTO response = residenceService.updateResidence(getSampleResidenceDto(false, null), 1L);

        assertThat(response).isNull();
    }
}
