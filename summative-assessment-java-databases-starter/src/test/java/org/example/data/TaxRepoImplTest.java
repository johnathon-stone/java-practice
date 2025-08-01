package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Tax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaxRepoImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TaxRepo taxRepo;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("{call set_known_good_state()}");
    }

    @Test
    void getCurrentTax_ValidData_ReturnsCurrentTax() throws RecordNotFoundException, InternalErrorException {
        LocalDate testDate = LocalDate.now();

        Tax tax = taxRepo.getCurrentTax(testDate);

        assertNotNull(tax);
        assertEquals(6.25, tax.getTaxPercentage().doubleValue());
    }

    @Test
    void getCurrentTax_InvalidData_ReturnsNull() throws RecordNotFoundException, InternalErrorException {
        LocalDate testDate = LocalDate.now().minusYears(20);

        assertThrows(InternalErrorException.class, () -> taxRepo.getCurrentTax(testDate));
    }
}
