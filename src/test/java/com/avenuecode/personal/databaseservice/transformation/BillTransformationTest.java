package com.avenuecode.personal.databaseservice.transformation;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.model.Bill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleBill;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleBillDto;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleBillList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class BillTransformationTest {

    @Test
    public void testToBill() {

        Bill bill = BillTransformation.toBill(getSampleBillDto(true, 1L));
        assertThat(bill).isNotNull();
        assertThat(bill.getId()).isEqualTo(1L);
    }

    @Test
    public void testToBillDTO() {

        BillDTO billDTO = BillTransformation.toBillDTO(getSampleBill(true, 1L));
        assertThat(billDTO).isNotNull();
        assertThat(billDTO.getId()).isEqualTo(1L);
    }

    @Test
    public void testToBillDTOList() {

        Set<BillDTO> billDTOList = BillTransformation.toBillDTOList(getSampleBillList());
        assertThat(billDTOList).isNotNull();
        assertThat(billDTOList.size()).isEqualTo(2);
    }

}
