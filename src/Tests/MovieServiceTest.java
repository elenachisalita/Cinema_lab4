package Tests;

import Domain.IValidator;
import Domain.Movie;
import Domain.MovieValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.MovieService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private IValidator<Movie> validatorMovie = new MovieValidator();
    private IRepository<Movie> movieRepository = new InMemoryRepository<>(validatorMovie);
    private MovieService movieService = new MovieService(movieRepository);
    @Test
    void addOrUpdate() {


    }
    void fullTextSearchMovie() {
        movieService.addOrUpdate("1", "titanic", "2000", 32, true);
        assertEquals(1,movieService.fullTextSearchMovie("titanic").size());
        assertEquals(0,movieService.fullTextSearchMovie("skdjsk").size());

    }

}