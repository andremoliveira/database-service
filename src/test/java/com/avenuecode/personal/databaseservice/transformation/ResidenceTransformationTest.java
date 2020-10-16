package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.model.Residence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleResidence;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleResidenceDto;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleResidenceList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ResidenceTransformationTest {

    @Test
    public void testToBill() {

        Residence residence = ResidenceTransformation.toResidence(getSampleResidenceDto(true, 1L));
        assertThat(residence).isNotNull();
        assertThat(residence.getId()).isEqualTo(1L);
    }

    @Test
    public void testToBillDTO() {

        ResidenceDTO residenceDTO = ResidenceTransformation.toResidenceDTO(getSampleResidence(true, 1L));
        assertThat(residenceDTO).isNotNull();
        assertThat(residenceDTO.getId()).isEqualTo(1L);
    }

    @Test
    public void testToBillDTOList() {

        Set<ResidenceDTO> residenceDTOSet = ResidenceTransformation.toResidenceDTOList(getSampleResidenceList());
        assertThat(residenceDTOSet).isNotNull();
        assertThat(residenceDTOSet.size()).isEqualTo(2);
    }

}
