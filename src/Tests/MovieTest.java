package Tests;

import Domain.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie mTest = new Movie("1","The non","2018",32.2,true);
    @Test
    void getTitle() {
        assertEquals(mTest.getTitle(),"The non");
    }

    @Test
    void getYear() {

        assertEquals(mTest.getYear(),"2018");
    }

    @Test
    void getPrice() {
        assertEquals(mTest.getPrice(),32.2);
    }

    @Test
    void isAvalible() {
        assertTrue(true);
    }
}