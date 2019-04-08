package Domain;

import java.util.Objects;

public class Movie extends Entity {

    private String id, title;
    private String year;
    private double price;
    private boolean avalible;

    public Movie(String id, String title, String year, double price, boolean avalible) {

        super(id);
        this.id = id;
        this.title = title;
        this.year = year;
        this.price = price;
        this.avalible = avalible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return
                id.equals(movie.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, price, avalible);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvalible() {
        return avalible;
    }

    public void setAvalible(boolean avalible) {
        this.avalible = avalible;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", avalible=" + avalible +
                '}';
    }
}
