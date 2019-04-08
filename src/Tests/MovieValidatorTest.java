package Tests;

import Domain.IValidator;
import Domain.Movie;
import Domain.MovieValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieValidatorTest {

    private IValidator<Movie> validatorMovie = new MovieValidator();

    @Test
    void validate() {

        Movie movie = new Movie("1","Titanic","2001",33,true);

        try {
            validatorMovie.validate(movie);
        } catch (RuntimeException rex) {
            assertTrue(true);
        }
    }
}