package oops.assignments.bookmyshow.objects;

public class Auditorium {

    private String id;
    private CinemaHall cinemaHall;
    private Integer numOfRows;
    private Integer numOfSeatsPerRow;

    public Auditorium(String id, CinemaHall cinemaHall, Integer numOfRows, Integer numOfSeatsPerRow) {
        this.id = id;
        this.cinemaHall = cinemaHall;
        this.numOfRows = numOfRows;
        this.numOfSeatsPerRow = numOfSeatsPerRow;
    }

    public String getId() {
        return id;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public Integer getNumOfSeatsPerRow() {
        return numOfSeatsPerRow;
    }
}
