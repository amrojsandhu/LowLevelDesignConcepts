package oops.assignments.bookmyshow.dao;

import oops.assignments.bookmyshow.objects.Show;

public class ShowDAO {

    private String id;
    private Long timeInEpoch;
    private Integer costPerSeat;
    private String movieId;
    private String seatingGridId;
    private String auditoriumId;

    public ShowDAO(Show show) {
        this.id = show.getId();
        this.timeInEpoch = show.getTimeInEpoch();
        this.costPerSeat = show.getCostPerSeat();
        this.movieId = show.getMovie().getId();
        this.seatingGridId = show.getSeatingGrid().getId();
        this.auditoriumId = show.getAuditorium().getId();
    }

    public String getId() {
        return id;
    }

    public Long getTimeInEpoch() {
        return timeInEpoch;
    }

    public Integer getCostPerSeat() {
        return costPerSeat;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getSeatingGridId() {
        return seatingGridId;
    }

    public String getAuditoriumId() {
        return auditoriumId;
    }
}
