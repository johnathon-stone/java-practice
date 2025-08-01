package org.example.data;

import org.example.data.exceptions.InternalErrorException;
import org.example.data.exceptions.RecordNotFoundException;
import org.example.model.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getServerById_ValidData_ReturnsServer() throws RecordNotFoundException, InternalErrorException {
        int testId = 1;

        Server server = serverRepo.getServerById(testId);

        assertNotNull(server);
        assertEquals("Mersey", server.getFirstName());
        assertEquals("Giacometti", server.getLastName());
    }

    @Test
    void getServerById_InvalidData_ThrowsException() throws RecordNotFoundException, InternalErrorException {
        int testId = 99;

        assertThrows(InternalErrorException.class, () -> serverRepo.getServerById(testId));
    }

    @Test
    void getAllAvailableServers_ValidData_ReturnsServers() throws RecordNotFoundException, InternalErrorException {
        LocalDate testDate = LocalDate.now();

        List<Server> servers = serverRepo.getAllAvailableServers(testDate);

        assertNotNull(servers);
        assertFalse(servers.isEmpty());
        assertEquals(14, servers.size());
    }

    @Test
    void getAllAvailableServers_InvalidData_ReturnsEmpty() throws RecordNotFoundException, InternalErrorException {
        LocalDate testDate = LocalDate.now().minusYears(20);

        List<Server> servers = serverRepo.getAllAvailableServers(testDate);

        assertEquals(0, servers.size());
    }
}
