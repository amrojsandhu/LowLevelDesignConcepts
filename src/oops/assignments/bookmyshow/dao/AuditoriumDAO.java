package oops.assignments.bookmyshow.dao;

import oops.assignments.bookmyshow.objects.Auditorium;

public class AuditoriumDAO {

    private String id;
    private String cinemaHallId;
    private Integer numOfRows;
    private Integer numOfSeatsPerRow;

    public AuditoriumDAO(Auditorium auditorium) {
        this.id = auditorium.getId();
        this.cinemaHallId = auditorium.getCinemaHall().getId();
        this.numOfRows = auditorium.getNumOfRows();
        this.numOfSeatsPerRow = auditorium.getNumOfSeatsPerRow();
    }

    public String getId() {
        return id;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public Integer getNumOfSeatsPerRow() {
        return numOfSeatsPerRow;
    }
}
