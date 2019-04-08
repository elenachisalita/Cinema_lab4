package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationValidator implements IValidator<Reservation>{

    public void validate (Reservation reservation) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm");
        try {
            simpleDateFormat.parse(reservation.getDate());

        } catch (ParseException pe) {

            throw new RuntimeException("Date is not in a right format.");
        }
        try {
            simpleTimeFormat.parse(reservation.getTime());
        } catch (ParseException pe) {
            throw new RuntimeException ("Time is not in the right format");
        }
    }
}
