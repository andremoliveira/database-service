package com.avenuecode.personal.databaseservice.repository;

import com.avenuecode.personal.databaseservice.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}
