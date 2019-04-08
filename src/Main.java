import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.MovieService;
import Service.ClientService;
import Service.ReservationService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        IValidator<Movie> movieValidator = new MovieValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator reservationValidator = new ReservationValidator();

        IRepository<Movie> movieRepository = new InMemoryRepository<>(movieValidator);
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository<Reservation> reservationRepository = new InMemoryRepository<>(reservationValidator);

        MovieService movieService = new MovieService(movieRepository);
        ClientService clientService = new ClientService(clientRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, movieRepository);

        Console console = new Console(movieService, clientService, reservationService);
        console.run();
    }
}