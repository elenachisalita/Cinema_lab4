package Tests;

import Domain.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private Client test = new Client("1","Pop","Ioan","2950420345324","29.04.1995","20.05.2019");
    @Test
    void getLastName() {
        assertEquals(test.getLastName(),"Pop");
    }

    @Test
    void getFirstName() {
        assertEquals(test.getFirstName(),"Ioan");
    }

    @Test
    void getCNP() {
        assertEquals(test.getCNP(),"2950420345324");
    }

    @Test
    void getDateOfBirth() {
        assertEquals(test.getDateOfBirth(),"29.04.1995");
    }

    @Test
    void getDateOfRegistration() {
        assertEquals(test.getDateOfRegistration(),"20.05.2019");
    }
}