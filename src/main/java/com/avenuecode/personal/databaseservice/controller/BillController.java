package com.avenuecode.personal.databaseservice.controller;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.resource.BillResource;
import com.avenuecode.personal.databaseservice.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class BillController implements BillResource {

    private BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }


    @Override
    public ResponseEntity<BillDTO> getBill(Long id) {
        BillDTO bill = billService.findById(Long.valueOf(id));
        if (bill == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Set<BillDTO>> getAllBills() {
        Set<BillDTO> bills = billService.listAll();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BillDTO> createBill(BillDTO billDTO) {
        billDTO = billService.saveBill(billDTO);
        return new ResponseEntity<>(billDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteBill(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<BillDTO> updateBill(BillDTO billDTO, Long id) {
        billDTO = billService.updateBill(billDTO, Long.valueOf(id));
        if (billDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(billDTO, HttpStatus.OK);
    }


}
