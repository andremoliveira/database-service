package com.avenuecode.personal.databaseservice.service;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.model.Bill;
import com.avenuecode.personal.databaseservice.repository.BillRepository;
import com.avenuecode.personal.databaseservice.transformation.BillTransformation;
import com.avenuecode.personal.databaseservice.transformation.ResidenceTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BillService {

    private BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public BillDTO saveBill(BillDTO billDTO) {

        Bill bill = BillTransformation.toBill(billDTO);

        bill.setDateCreation(LocalDateTime.now());
        bill.setDateUpdating(LocalDateTime.now());

        return BillTransformation.toBillDTO(billRepository.save(bill));
    }

    @Transactional
    public BillDTO findById(Long id) {
        Optional<Bill> userEntity = billRepository.findById(id);

        if(!userEntity.isPresent())
            return null;

        return BillTransformation.toBillDTO(userEntity.get());
    }

    @Transactional
    public Set<BillDTO> listAll() {
        Set<Bill> bills = new HashSet<>();
        billRepository.findAll().forEach(bills::add);
        return BillTransformation.toBillDTOList(bills);
    }

    @Transactional
    public BillDTO updateBill(BillDTO billDTO, long id) {
        Optional<Bill> persistedBill = billRepository.findById(id);

        if (!persistedBill.isPresent())
            return null;

        billDTO.setId(id);
        billDTO.setDateUpdating(LocalDateTime.now());
        billDTO.setDateCreation(persistedBill.get().getDateCreation());
        billDTO.setResidence(ResidenceTransformation.toResidenceDTO(persistedBill.get().getResidence()));

        return BillTransformation.toBillDTO(billRepository.save(BillTransformation.toBill(billDTO)));
    }
}
