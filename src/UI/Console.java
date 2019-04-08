package UI;

import Domain.Movie;
import Domain.Client;
import Domain.Reservation;
import Service.MovieService;
import Service.ClientService;
import Service.ReservationService;

import java.util.Scanner;

public class Console {

    private MovieService movieService;
    private ClientService clientService;
    private ReservationService reservationService;

    private Scanner scanner;

    public Console(MovieService movieService, ClientService clientService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientService = clientService;
        this.reservationService = reservationService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("3. Reservation CRUD");
        System.out.println("4. Search Clients");
        System.out.println("5. Search Movies");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runClientCrud();
                    break;
                case "3":
                    runReservationCrud();
                    break;
                case "4":
                    runClientsSearch();
                    break;
                case "5":
                    runMoviesSearch();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void runClientsSearch() {
        System.out.println("Dati cautarea: ");
        String text = scanner.nextLine();
        System.out.println("Rezultatele cautarii sunt:");
        for (Client c : clientService.fullTextSearch(text)) {
            System.out.println(c);
        }
    }
    private void runMoviesSearch() {
        System.out.println("Dati cautarea: ");
        String text = scanner.nextLine();
        System.out.println("Rezultatele cautarii sunt:");
        for (Movie c : movieService.fullTextSearchMovie(text)) {
            System.out.println(c);
        }
    }


    private void runReservationCrud() {
        while (true) {
            System.out.println("1. Add or update a reservation");
            System.out.println("2. Remove a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateReservation();
                    break;
                case "2":
                    handleRemoveReservation();
                    break;
                case "3":
                    handleViewReservations();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewReservations() {
        for (Reservation reservation : reservationService.getAll()) {
            System.out.println(reservation);
        }
    }

    private void handleRemoveReservation() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            reservationService.remove(id);

            System.out.println("Reservation removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateReservation() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter movie id (empty to not change for update): ");
            String idMovie = scanner.nextLine();
            System.out.print("Enter client card (empty to not change for update): ");
            String idClientCard = scanner.nextLine();
            System.out.print("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            Reservation reservation = reservationService.addOrUpdate(id, idMovie, idClientCard,date, time);
            System.out.println(String.format("Added reservation id=%s, bonus = %f",reservation.getId(),reservation.getBonusedPrice()));//
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCrud() {
        while (true) {
            System.out.println("1. Add or update a client");
            System.out.println("2. Remove a client");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClient();
                    break;
                case "2":
                    handleRemoveClient();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClients() {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

    private void handleRemoveClient() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            clientService.remove(id);

            System.out.println("Client removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClient() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();

            clientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runMovieCrud() {
        while (true) {
            System.out.println("1. Add or update a movie");
            System.out.println("2. Remove a movie");
            System.out.println("3. View all movies");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMovie();
                    break;
                case "2":
                    handleRemoveMovie();
                    break;
                case "3":
                    handleViewMovie();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewMovie() {
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
    }

    private void handleRemoveMovie() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            movieService.remove(id);

            System.out.println("Movie removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateMovie() {

        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter name (empty to not change for update): ");
            String title = scanner.nextLine();
            System.out.print("Enter year (empty to not change for update): ");
            String year = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter avalible (true / false): ");
            boolean avalible = Boolean.parseBoolean(scanner.nextLine());

            movieService.addOrUpdate(id, title, year, price, avalible);

            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}
