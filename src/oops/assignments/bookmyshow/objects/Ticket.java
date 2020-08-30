package oops.assignments.bookmyshow.objects;

public class Ticket {

    private String id;
    private Account account;
    private Show show;
    private Long bookedOnEpoch;
    private String seat;

    public Ticket(String id, Account account, Long bookedOnEpoch, String seat, Show show) {
        this.id = id;
        this.account = account;
        this.bookedOnEpoch = bookedOnEpoch;
        this.seat = seat;
        this.show = show;
    }

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Long getBookedOnEpoch() {
        return bookedOnEpoch;
    }

    public String getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }
}
