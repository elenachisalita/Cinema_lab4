package Tests;

import Domain.Client;
import Domain.ClientValidator;
import Domain.IValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientValidatorTest {

    private IValidator<Client> validatorClient = new ClientValidator();

    @Test
    void validate() {
        Client client = new Client("1","fsda","Sdas","2945678324567", "22.03.1990","29.04.2019");


        try {
            validatorClient.validate(client);
        } catch (RuntimeException rex) {
            assertTrue(true);
        }
    }
}