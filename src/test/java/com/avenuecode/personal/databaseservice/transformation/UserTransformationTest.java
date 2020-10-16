package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleUser;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleUserDTOList;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleUserDto;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleUserList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserTransformationTest {

    @Test
    public void testToBill() {

        UserEntity userEntity = UserTransformation.toUser(getSampleUserDto(true, 1L));
        assertThat(userEntity).isNotNull();
        assertThat(userEntity.getId()).isEqualTo(1L);
    }

    @Test
    public void testToBillDTO() {

        UserDTO userDTO = UserTransformation.toUserDTO(getSampleUser(true, 1L));
        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getId()).isEqualTo(1L);
    }

    @Test
    public void testToBillDTOList() {

        Set<UserDTO> userDTOSet = UserTransformation.toUserDTOList(getSampleUserList());
        assertThat(userDTOSet).isNotNull();
        assertThat(userDTOSet.size()).isEqualTo(2);
    }

    @Test
    public void testToBillList() {

        Set<UserEntity> userEntities = UserTransformation.toUserList(getSampleUserDTOList());
        assertThat(userEntities).isNotNull();
        assertThat(userEntities.size()).isEqualTo(2);
    }

}
