package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.model.PaymentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class PaymentTypeImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PaymentTypeRepo paymentTypeRepo;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("{call set_known_good_state()}");
    }

    @Test
    void getAll_ReturnsList() throws InternalErrorException {
        List<PaymentType> testList = paymentTypeRepo.getAll();

        assertNotNull(testList);
        assertEquals(5, testList.size());
    }
}
