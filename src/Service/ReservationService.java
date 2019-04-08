package Service;

import Domain.Movie;
import Domain.Reservation;
import Repository.IRepository;


import java.util.List;

public class ReservationService {


    private IRepository<Reservation> reservationRepository;
    private IRepository<Movie> movieRepository;

    public ReservationService(IRepository<Reservation> reservationRepository, IRepository<Movie> movieRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
    }

    public Reservation addOrUpdate (String id, String idMovie, String idClientCard, String date, String time) {
        Reservation existing = reservationRepository.findById(id);
        if (existing != null) {
            //keep unchanged fields as they were
            if (idMovie.isEmpty()) {
                idMovie = existing.getIdMovie();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdClientCard();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

        Movie movieSold = movieRepository.findById(idMovie);
        if (movieSold == null) {
            throw new RuntimeException("There is no movie with the given id!");
        }
        double basePrice = movieSold.getPrice();
        double bonus = 0;
        if(idClientCard != null && movieSold.isAvalible()) {
            bonus = 0.1;
        }

        Reservation reservation = new Reservation(id, idMovie, idClientCard, date, time,basePrice, bonus);
        reservationRepository.upsert(reservation);
        return reservation;
    }


    public void remove (String id) {
        reservationRepository.remove(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
}
