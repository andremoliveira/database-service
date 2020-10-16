package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.model.Bill;

import java.util.HashSet;
import java.util.Set;

public class BillTransformation {

    private BillTransformation() {}

    public static Bill toBill(BillDTO billDTO) {

        Bill bill = new Bill();

        bill.setId(billDTO.getId());
        bill.setResidence(ResidenceTransformation.toResidence(billDTO.getResidence()));
        bill.setDescription(billDTO.getDescription());
        bill.setDateUpdating(billDTO.getDateUpdating());
        bill.setDateCreation(billDTO.getDateCreation());
        bill.setDueDate(billDTO.getDueDate());
        bill.setPayingUser(UserTransformation.toUser(billDTO.getPayingUser()));
        bill.setPaymentDay(billDTO.getPaymentDay());


        return bill;
    }

    public static BillDTO toBillDTO(Bill bill) {

        BillDTO billDTO = new BillDTO();

        billDTO.setId(bill.getId());
        billDTO.setResidence(ResidenceTransformation.toResidenceDTO(bill.getResidence()));
        billDTO.setDescription(bill.getDescription());
        billDTO.setDateUpdating(bill.getDateUpdating());
        billDTO.setDateCreation(bill.getDateCreation());
        billDTO.setDueDate(bill.getDueDate());
        billDTO.setPayingUser(UserTransformation.toUserDTO(bill.getPayingUser()));
        billDTO.setPaymentDay(bill.getPaymentDay());

        return billDTO;

    }

    public static Set<BillDTO> toBillDTOList(Set<Bill> bills) {

        Set<BillDTO> billsDTO = new HashSet<>();

        for(Bill bill : bills) {
            billsDTO.add(toBillDTO(bill));
        }

        return billsDTO;
    }


}
