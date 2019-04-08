package Domain;

public class MovieValidator implements IValidator<Movie> {

    public void validate (Movie movie) {

        String errors = "";
        if (movie.getPrice() <= 0) {
            errors += "The price must be > 0!\n";

        }
        if (movie.getYear().isEmpty()) {
            errors += "The year must be > 0 !\n";
        }


        if (!errors.isEmpty()) {
            throw new RuntimeException(errors);
        }
    }
}
