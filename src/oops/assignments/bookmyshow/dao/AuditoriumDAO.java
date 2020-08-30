package oops.assignments.bookmyshow.dao;

import oops.assignments.bookmyshow.objects.Auditorium;

public class AuditoriumDAO {

    private String id;
    private String cinemaId;
    private Integer numOfRows;
    private Integer numOfSeatsPerRow;

    public AuditoriumDAO(Auditorium auditorium) {
        this.id = auditorium.getId();
        this.cinemaId = auditorium.getCinema().getId();
        this.numOfRows = auditorium.getNumOfRows();
        this.numOfSeatsPerRow = auditorium.getNumOfSeatsPerRow();
    }

    public String getId() {
        return id;
    }

    public String getCinemaHallId() {
        return cinemaId;
    }

    public Integer getNumOfRows() {
        return numOfRows;
    }

    public Integer getNumOfSeatsPerRow() {
        return numOfSeatsPerRow;
    }
}
