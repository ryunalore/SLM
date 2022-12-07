package fhtw.maintenance_monitor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MaintenanceMonitorControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void message() {
        // Arrange
        message_reset();
        String message_expected = "Everything operates as expected";

        // Act
        String message_actual = testRestTemplate.getForObject("http://localhost:" + port + "/api/message", String.class);

        // Assert
        assertEquals(message_expected,message_actual);
    }

    @ParameterizedTest
    @CsvSource({"Service+checks:+No+power+until+05:00+pm, Service checks: No power until 05:00 pm","Service+checks:+No+power+until+20:00+pm, Service checks: No power until 20:00 pm"})
    void message_set(String msg_set, String msg_result){
        //Arrange

        String msg_expected_status_return = "ok";

        //Act
        String msg_received_status_return = testRestTemplate.getForObject("http://localhost:" + port + String.format("/api/message/set?m=%s", msg_set), String.class);
        String msg_actual = testRestTemplate.getForObject("http://localhost:" + port + "/api/message", String.class);

        //Assert
        assertEquals(msg_expected_status_return, msg_received_status_return);
        assertEquals(msg_result, msg_actual);
    }

    @Test
    void message_reset(){
        //Arrange
        String msg_expected = "Everything operates as expected";

        //Act
        String msg_received_status_return = testRestTemplate.getForObject("http://localhost:" + port + "/api/message/reset", String.class);
        String msg_actual = testRestTemplate.getForObject("http://localhost:" + port + "/api/message", String.class);

        //Assert
        assertEquals("ok", msg_received_status_return);
        assertEquals(msg_expected, msg_actual);
    }
}