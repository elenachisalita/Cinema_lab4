package Tests;

import Domain.IValidator;
import Domain.Reservation;
import Domain.ReservationValidator;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ReservationValidatorTest {
    private IValidator<Reservation> validatorReservation = new ReservationValidator();

    @Test
    void validate() {
        Reservation reservation = new Reservation("1", "11", "11", "22.03.2019","22.23",23,2.3);

        try {
            validatorReservation.validate(reservation);
        } catch (RuntimeException rex) {
            assertTrue(true);
        }


    }
}