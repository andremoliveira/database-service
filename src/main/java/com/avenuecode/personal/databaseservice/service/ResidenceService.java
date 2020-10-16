package com.avenuecode.personal.databaseservice.service;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.model.Residence;
import com.avenuecode.personal.databaseservice.repository.ResidenceRepository;
import com.avenuecode.personal.databaseservice.transformation.ResidenceTransformation;
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
public class ResidenceService {

    private ResidenceRepository residenceRepository;


    @Autowired
    public ResidenceService(ResidenceRepository residenceRepository) {
        this.residenceRepository = residenceRepository;
    }

    public ResidenceDTO saveResidence(ResidenceDTO residenceDTO) {
//        addressRepository.save(residence.getAddress());
        residenceDTO.setDateCreation(LocalDateTime.now());
        residenceDTO.setDateUpdating(LocalDateTime.now());
        return ResidenceTransformation.toResidenceDTO(residenceRepository.save(ResidenceTransformation.toResidence(residenceDTO)));
    }

    @Transactional
    public ResidenceDTO findById(Long id) {
        Optional<Residence> residence = residenceRepository.findById(id);

        if(!residence.isPresent())
            return null;

        return ResidenceTransformation.toResidenceDTO(residence.get());
    }

    @Transactional
    public Set<ResidenceDTO> listAll() {
        Set<Residence> residences = new HashSet<>();
        residenceRepository.findAll().forEach(residences::add);
        return ResidenceTransformation.toResidenceDTOList(residences);
    }

    public HttpStatus deleteResidence(Long id) {

        try {
            residenceRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.NO_CONTENT;
    }

    public ResidenceDTO updateResidence(ResidenceDTO residenceDTO, long id) {

        Optional<Residence> persistedResidence = residenceRepository.findById(id);

        if (!persistedResidence.isPresent())
            return null;


        residenceDTO.setId(id);
        residenceDTO.setDateUpdating(LocalDateTime.now());
        residenceDTO.setDateCreation(persistedResidence.orElse(null).getDateCreation());

        return ResidenceTransformation.toResidenceDTO(residenceRepository.save(ResidenceTransformation.toResidence(residenceDTO)));

    }
}
