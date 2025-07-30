package org.example.service;

import org.example.data.OrderRepo;
import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BistroServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private BistroService svc;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("{call set_known_good_state()}");
    }

    @Test
    void testCalculateOrderTotals() throws RecordNotFoundException, InternalErrorException {
        Order expected = orderRepo.getOrderById(1);
        Order actual = orderRepo.getOrderById(1);

        svc.calculateOrderTotals(actual);
        assertEquals(expected, actual);
    }
}