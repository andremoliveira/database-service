package com.avenuecode.personal.databaseservice.repository;

import com.avenuecode.personal.databaseservice.model.Residence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResidenceRepository extends CrudRepository<Residence, Long> {
}
