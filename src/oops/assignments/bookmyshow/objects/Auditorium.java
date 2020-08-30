package oops.assignments.bookmyshow.objects;

public class Auditorium {

    private String id;
    private Cinema cinema;
    private Integer numOfRows;
    private Integer numOfSeatsPerRow;

    public Auditorium(String id, Cinema cinema, Integer numOfRows, Integer numOfSeatsPerRow) {
        this.id = id;
        this.cinema = cinema;
        this.numOfRows = numOfRows;
        this.numOfSeatsPerRow = numOfSeatsPerRow;
    }

    public String getId() {
        return id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public Integer getNumOfSeatsPerRow() {
        return numOfSeatsPerRow;
    }
}
