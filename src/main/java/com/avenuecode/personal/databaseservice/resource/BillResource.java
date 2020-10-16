package com.avenuecode.personal.databaseservice.resource;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
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
public interface BillResource {

    @GetMapping("/bill/{id}")
    ResponseEntity<BillDTO> getBill(@PathVariable Long id);

    @GetMapping("/bill")
    ResponseEntity<Set<BillDTO>> getAllBills();

    @PostMapping("/bill")
    ResponseEntity<BillDTO> createBill(@RequestBody BillDTO billDTO);

    @DeleteMapping("/bill/{id}")
    ResponseEntity<String> deleteBill(@PathVariable Long id);

    @PutMapping("/bill/{id}")
    ResponseEntity<BillDTO> updateBill(@RequestBody BillDTO billDTO, @PathVariable Long id);
}
