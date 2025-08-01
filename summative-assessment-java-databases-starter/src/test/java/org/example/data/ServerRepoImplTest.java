package org.example.data;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class ServerRepoImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ServerRepo serverRepo;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("{call set_known_good_state()}");
    }
}
