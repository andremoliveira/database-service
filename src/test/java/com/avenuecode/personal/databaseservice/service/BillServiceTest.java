package com.avenuecode.personal.databaseservice.service;

import com.avenuecode.personal.databaseservice.dto.BillDTO;
import com.avenuecode.personal.databaseservice.repository.BillRepository;
import com.avenuecode.personal.databaseservice.transformation.BillTransformation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleBill;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleBillDto;
import static com.avenuecode.personal.databaseservice.util.SampleGenerator.getSampleBillList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BillServiceTest {

    @MockBean
    private BillRepository billRepository;

    private BillService billService;

    @Before
    public void setUp() {
        this.billService = new BillService(billRepository);
    }

    @Test
    public void saveUser_withValidValues_shouldReturnUserDto() {
        when(billRepository.save(any())).thenReturn(BillTransformation.toBill(getSampleBillDto(true, 1L)));
        BillDTO response = billService.saveBill(getSampleBillDto(false, null));

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    public void findById_withValidValues_shouldReturnUserDto() {
        when(billRepository.findById(any())).thenReturn(Optional.of(BillTransformation.toBill(getSampleBillDto(true, 1L))));
        BillDTO response = billService.findById(1L);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    public void findById_withValidValuesButNotFound_shouldReturnNull() {
        when(billRepository.findById(any())).thenReturn(Optional.empty());
        BillDTO response = billService.findById(1L);

        assertThat(response).isNull();
    }

    @Test
    public void listAll_withValidValues_shouldReturnListOfUser() {
        when(billRepository.findAll()).thenReturn(getSampleBillList());
        Set<BillDTO> response = billService.listAll();

        assertThat(response).isNotNull();
        assertThat(response.size()).isEqualTo(2);
    }

    @Test
    public void updateUser_withValidValues_shouldReturnListOfUser() {
        BillDTO billDTO = getSampleBillDto(false, 1L);
        billDTO.setDescription("A different description");
        billDTO.setId(1L);
        when(billRepository.findById(any())).thenReturn(Optional.of(getSampleBill(true, 1L)));
        when(billRepository.save(any())).thenReturn(BillTransformation.toBill(billDTO));

        BillDTO response = billService.updateBill(billDTO, 1L);

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getDescription()).isEqualTo("A different description");
    }

    @Test
    public void updateUser_withNonExistentUser_shouldReturnNull() {
        when(billRepository.findById(any())).thenReturn(Optional.empty());
        BillDTO response = billService.updateBill(getSampleBillDto(false, null), 1L);

        assertThat(response).isNull();
    }
}
