package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.dto.UserDTO;
import com.avenuecode.personal.databaseservice.model.Residence;
import com.avenuecode.personal.databaseservice.model.UserEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.HashSet;
import java.util.Set;

public class ResidenceTransformation {

    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private ResidenceTransformation() {
    }

    public static Residence toResidence(ResidenceDTO residenceDTO) {

        BoundMapperFacade<ResidenceDTO, Residence> boundMapperFacade = mapperFactory.getMapperFacade(ResidenceDTO.class, Residence.class);
        return boundMapperFacade.map(residenceDTO);
    }

    public static ResidenceDTO toResidenceDTO(Residence residence) {

        BoundMapperFacade<Residence, ResidenceDTO> boundMapperFacade = mapperFactory.getMapperFacade(Residence.class, ResidenceDTO.class);
        return boundMapperFacade.map(residence);
    }

    public static Set<ResidenceDTO> toResidenceDTOList(Set<Residence> residences) {

        Set<ResidenceDTO> residenceDTOS = new HashSet<>();

        for(Residence residence : residences) {
            residenceDTOS.add(toResidenceDTO(residence));
        }

        return residenceDTOS;
    }
}
