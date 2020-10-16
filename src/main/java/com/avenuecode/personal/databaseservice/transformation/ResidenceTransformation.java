package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.model.Residence;

import java.util.HashSet;
import java.util.Set;

public class ResidenceTransformation {

    private ResidenceTransformation() {
    }

    public static Residence toResidence(ResidenceDTO residenceDTO) {

        Residence residence = new Residence();

        residence.setId(residenceDTO.getId());
        residence.setAddress(residenceDTO.getAddress());
        residence.setName(residenceDTO.getName());
        residence.setDateUpdating(residenceDTO.getDateUpdating());
        residence.setDateCreation(residenceDTO.getDateCreation());
        residence.setDateExclusion(residenceDTO.getDateExclusion());
        residence.setUsers(UserTransformation.toUserList(residenceDTO.getUsers()));

        return residence;
    }

    public static ResidenceDTO toResidenceDTO(Residence residence) {

        ResidenceDTO residenceDTO = new ResidenceDTO();

        residenceDTO.setId(residence.getId());
        residenceDTO.setAddress(residence.getAddress());
        residenceDTO.setName(residence.getName());
        residenceDTO.setDateUpdating(residence.getDateUpdating());
        residenceDTO.setDateCreation(residence.getDateCreation());
        residenceDTO.setDateExclusion(residence.getDateExclusion());
        residenceDTO.setUsers(UserTransformation.toUserDTOList(residence.getUsers()));

        return residenceDTO;

    }

    public static Set<ResidenceDTO> toResidenceDTOList(Set<Residence> residences) {

        Set<ResidenceDTO> residenceDTOS = new HashSet<>();

        for(Residence residence : residences) {
            residenceDTOS.add(toResidenceDTO(residence));
        }

        return residenceDTOS;
    }
}
