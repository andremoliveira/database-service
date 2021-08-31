package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.model.Bill;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.HashSet;
import java.util.Set;

public class BillTransformation {

    private static MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private BillTransformation() {}

    public static Bill toBill(BillDTO billDTO) {

        mapperFactory.classMap(BillDTO.class, Bill.class);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(billDTO, Bill.class);
    }

    public static BillDTO toBillDTO(Bill bill) {

        mapperFactory.classMap(Bill.class, BillDTO.class);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        return mapperFacade.map(bill, BillDTO.class);
    }

    public static Set<BillDTO> toBillDTOList(Set<Bill> bills) {

        Set<BillDTO> billsDTO = new HashSet<>();

        for(Bill bill : bills) {
            billsDTO.add(toBillDTO(bill));
        }

        return billsDTO;
    }
}
