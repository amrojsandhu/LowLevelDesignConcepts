package oops.assignments.bookmyshow.sro;

import oops.assignments.bookmyshow.objects.Ticket;

import java.util.Arrays;

public class Booking {

    private String id;
    private String userId;
    private String screenId;
    private String eventId;
    private String seatId;

    public Booking(Ticket ticket) {
        this.id = ticket.getId();
        this.userId = ticket.getAccount().getId();
        this.screenId = ticket.getShow().getAuditorium().getId();
        this.eventId = ticket.getShow().getId();
        this.seatId = ticket.getSeat();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getSeatId() {
        return seatId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{\n");
        sb.append("\tid: ").append(id).append(",\n");;
        sb.append("\tuserId: ").append(userId).append(",\n");;
        sb.append("\tscreenId: ").append(screenId).append(",\n");;
        sb.append("\teventId: ").append(eventId).append(",\n");;
        sb.append("\tseatId: ").append(seatId).append("\n");;
        sb.append('}');
        return sb.toString();
    }
}
