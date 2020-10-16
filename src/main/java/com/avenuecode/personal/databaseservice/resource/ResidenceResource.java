package com.avenuecode.personal.databaseservice.resource;

import com.avenuecode.personal.databaseservice.dto.ResidenceDTO;
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
public interface ResidenceResource {

    @GetMapping("/residence/{id}")
    ResponseEntity<ResidenceDTO> getResidence(@PathVariable Long id);

    @GetMapping("/residence")
    ResponseEntity<Set<ResidenceDTO>> getAllResidences();

    @PostMapping("/residence")
    ResponseEntity<String> createResidence(@RequestBody ResidenceDTO residence);

    @DeleteMapping("/residence/{id}")
    ResponseEntity<String> deleteResidence(@PathVariable Long id);

    @PutMapping("/residence/{id}")
    ResponseEntity<ResidenceDTO> updateResidence(@RequestBody ResidenceDTO residence, @PathVariable Long id);
}
