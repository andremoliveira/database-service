package com.avenuecode.personal.databaseservice.util;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.model.Bill;
import com.avenuecode.personal.databaseservice.model.Residence;
import com.avenuecode.personal.databaseservice.model.UserEntity;
import com.avenuecode.personal.databaseservice.transformation.ResidenceTransformation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class SampleGenerator {

    public static Set<Residence> getSampleResidenceList() {

        Set<Residence> residences = new HashSet<>();
        residences.add(getSampleResidence(true, 1L));
        residences.add(getSampleResidence(true, 2L));
        return residences;
    }

    public static ResidenceDTO getSampleResidenceDto(boolean response, Long id) {
        Set<UserDTO> users = new HashSet<>();
        users.add(getSampleUserDto(true, 1L));

        ResidenceDTO residenceDTO = new ResidenceDTO();
        residenceDTO.setAddress("Test street");
        residenceDTO.setName("House of Cards");
        residenceDTO.setUsers(users);

        if (response) {
            residenceDTO.setDateUpdating(LocalDateTime.now());
            residenceDTO.setDateCreation(LocalDateTime.now());
            residenceDTO.setId(id);
        }

        return residenceDTO;
    }

    public static Residence getSampleResidence(boolean response, Long id) {
        Set<UserEntity> users = new HashSet<>();
        users.add(getSampleUser(true, 1L));

        Residence residence = new Residence();
        residence.setAddress("Test street");
        residence.setName("House of Cards");
        residence.setUsers(users);

        if (response) {
            residence.setDateUpdating(LocalDateTime.now());
            residence.setDateCreation(LocalDateTime.now());
            residence.setId(id);
        }

        return residence;
    }

    public static Set<UserEntity> getSampleUserList() {

        Set<UserEntity> userEntities = new HashSet<>();
        userEntities.add(getSampleUser(true, 1L));
        userEntities.add(getSampleUser(true, 2L));
        return userEntities;
    }

    public static Set<UserDTO> getSampleUserDTOList() {

        Set<UserDTO> userDTOS = new HashSet<>();
        userDTOS.add(getSampleUserDto(true, 1L));
        userDTOS.add(getSampleUserDto(true, 2L));
        return userDTOS;
    }

    public static UserDTO getSampleUserDto(boolean response, Long id) {

        UserDTO userDTO = new UserDTO();
        userDTO.setName("Anakin Skywalker");
        userDTO.setEmail("dvader@email.com");

        if(response) {
            userDTO.setDateUpdating(LocalDateTime.now());
            userDTO.setDateCreation(LocalDateTime.now());
            userDTO.setId(id);
        }

        return userDTO;
    }

    public static UserEntity getSampleUser(boolean response, Long id) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Anakin Skywalker");
        userEntity.setEmail("dvader@email.com");

        if(response) {
            userEntity.setDateUpdating(LocalDateTime.now());
            userEntity.setDateCreation(LocalDateTime.now());
            userEntity.setId(id);
        }

        return userEntity;
    }

    public static Set<Bill> getSampleBillList() {

        Set<Bill> bills = new HashSet<>();
        bills.add(getSampleBill(true, 1L));
        bills.add(getSampleBill(true, 2L));
        return bills;
    }

    public static BillDTO getSampleBillDto(boolean response, Long id) {
        BillDTO billDTO = new BillDTO();
        billDTO.setDescription("Sample exception");
        billDTO.setDueDate(LocalDate.of(2100, Month.SEPTEMBER,29));
        billDTO.setResidence(getSampleResidenceDto(true, 1L));

        if(response) {
            billDTO.setDateUpdating(LocalDateTime.now());
            billDTO.setDateCreation(LocalDateTime.now());
            billDTO.setId(id);
        }

        return billDTO;
    }

    public static Bill getSampleBill(boolean response, Long id) {
        Bill bill = new Bill();
        bill.setDescription("Sample exception");
        bill.setDueDate(LocalDate.of(2100, Month.SEPTEMBER,29));
        bill.setResidence(getSampleResidence(true, 1L));

        if(response) {
            bill.setDateUpdating(LocalDateTime.now());
            bill.setDateCreation(LocalDateTime.now());
            bill.setId(id);
        }

        return bill;
    }

}
