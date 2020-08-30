package oops.assignments.bookmyshow.objects;

public class Show {

    private String id;
    private Long timeInEpoch;
    private Integer costPerSeat;
    private Movie movie;
    private SeatingGrid seatingGrid;
    private Auditorium auditorium;

    public Show(String id, Long timeInEpoch, Integer costPerSeat, Movie movie, SeatingGrid seatingGrid,
                Auditorium auditorium) {
        this.id = id;
        this.timeInEpoch = timeInEpoch;
        this.costPerSeat = costPerSeat;
        this.movie = movie;
        if (seatingGrid.getRows() != auditorium.getNumOfRows()
                || seatingGrid.getSeatsPerRow() != auditorium.getNumOfSeatsPerRow()) {
            throw new IllegalStateException("Auditorium and SeatingGrid are not compatible.");
        }
        this.seatingGrid = seatingGrid;
        this.auditorium = auditorium;
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

    public Movie getMovie() {
        return movie;
    }

    public SeatingGrid getSeatingGrid() {
        return seatingGrid;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }
}
