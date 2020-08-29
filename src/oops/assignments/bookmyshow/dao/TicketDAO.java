package oops.assignments.bookmyshow.dao;

import oops.assignments.bookmyshow.objects.Ticket;

public class TicketDAO {

    private String id;
    private String accountId;
    private String showId;
    private Long bookedOnEpoch;
    private String seat;

    public TicketDAO(Ticket ticket) {
        this.id = ticket.getId();
        this.accountId = ticket.getAccount().getId();
        this.showId = ticket.getShow().getId();
        this.bookedOnEpoch = ticket.getBookedOnEpoch();
        this.seat = ticket.getSeat();
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getShowId() {
        return showId;
    }

    public String getSeat() {
        return seat;
    }

    public Long getBookedOnEpoch() {
        return bookedOnEpoch;
    }
}
