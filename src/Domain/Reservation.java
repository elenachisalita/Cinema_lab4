package Domain;

public class Reservation extends Entity {

    private String id, idMovie, idClientCard, date, time;
    private double basePrice;
    private double bonus;

    public Reservation(String id, String idMovie, String idClientCard, String date, String time, double basePrice, double bonus) {

        super(id);
        this.id = id;
        this.idMovie = idMovie;
        this.idClientCard = idClientCard;
        this.date = date;
        this.time = time;
        this.basePrice = basePrice;
        this.bonus = bonus;
    }


    public double getBonusedPrice() {
        return bonus * basePrice;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", idMovie='" + idMovie + '\'' +
                ", idClientCard='" + idClientCard + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", bonus='" + bonus + '\'' +
                '}';
    }



    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(String idClientCard) {
        this.idClientCard = idClientCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
