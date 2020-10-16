package com.avenuecode.personal.databaseservice.controller;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
import com.avenuecode.personal.databaseservice.resource.ResidenceResource;
import com.avenuecode.personal.databaseservice.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ResidenceController implements ResidenceResource {

    private ResidenceService residenceService;

    @Autowired
    public ResidenceController(ResidenceService residenceService) {
        this.residenceService = residenceService;
    }

    @Override
    public ResponseEntity<ResidenceDTO> getResidence(Long id) {

        ResidenceDTO residenceDTO = residenceService.findById(id);
        if (residenceDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(residenceDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<ResidenceDTO>> getAllResidences() {
        return new ResponseEntity<>(residenceService.listAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createResidence(ResidenceDTO residence) {
        residence = residenceService.saveResidence(residence);
        return new ResponseEntity<>(residence.getId().toString(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteResidence(Long id) {
        return new ResponseEntity<>(residenceService.deleteResidence(Long.valueOf(id)));
    }


    @Override
    public ResponseEntity<ResidenceDTO> updateResidence(ResidenceDTO residence, Long id) {
        residence = residenceService.updateResidence(residence, id);
        if(residence == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(residence, HttpStatus.OK);
    }
}
