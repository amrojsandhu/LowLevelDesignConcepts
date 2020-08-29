package oops.assignments.bookmyshow.services;

import oops.assignments.bookmyshow.objects.SeatingGrid;
import oops.assignments.bookmyshow.objects.Show;
import oops.assignments.bookmyshow.objects.Ticket;
import oops.assignments.bookmyshow.repository.SeatingGridRepository;
import oops.assignments.bookmyshow.repository.ShowRepository;
import oops.assignments.bookmyshow.repository.TicketRepository;
import oops.assignments.bookmyshow.repository.UserRepository;
import oops.assignments.bookmyshow.sro.Booking;

public class BookingService {

    private ShowRepository showRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;
    private SeatingGridRepository seatingGridRepository;

    private PaymentService paymentService;

    public BookingService(ShowRepository showRepository, UserRepository userRepository,
                          TicketRepository ticketRepository, SeatingGridRepository seatingGridRepository,
                          PaymentService paymentService) {
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.seatingGridRepository = seatingGridRepository;
        this.paymentService = paymentService;
    }

    /**
     * @param seatId
     * @param eventId
     * @param theaterId is ignored. See assumptions in readme.
     * @param userId
     * @return
     */
    public String bookEvent(String seatId, String eventId, String theaterId, String userId) {
        System.out.println("Started booking for seatId: " + seatId);
        Show show = showRepository.getShowById(eventId);

        Integer row = Integer.parseInt(seatId) % show.getAuditorium().getNumOfRows();
        Integer seatInTheRow = Integer.parseInt(seatId) % show.getAuditorium().getNumOfSeatsPerRow();
        boolean paymentStatus = bookSeat(show, row, seatInTheRow);
        System.out.println("Finished payment for seatId: " + seatId + ", with status: " + paymentStatus);
        if(!paymentStatus) {
            return null;
        }

        long bookedAt = System.currentTimeMillis();
        Ticket ticket = new Ticket(generateTicketId(seatId, eventId), userRepository.getById(userId),
                bookedAt, seatId, show);
        ticketRepository.save(ticket);
        System.out.println("Finished booking for seatId: " + seatId + ", ticketId: " + ticket.getId());
        return ticket.getId();
    }

    public Booking fetchBooking(String bookingId) {
        Ticket ticket = ticketRepository.getTicketById(bookingId);
        return new Booking(ticket);
    }

    private boolean bookSeat(Show show, int row, int seatInTheRow) {
        SeatingGrid seatingGrid = show.getSeatingGrid();
        seatingGrid.attainLock(row, seatInTheRow);
        seatingGrid.bookSeat(row, seatInTheRow);
        seatingGridRepository.save(seatingGrid);
        boolean paymentSuccess = paymentService.makePayment(show.getCostPerSeat());
        if (!paymentSuccess) {
            seatingGrid.cancelSeat(row, seatInTheRow);
            seatingGridRepository.save(seatingGrid);
        }
        seatingGrid.releaseLock(row, seatInTheRow);
        return paymentSuccess;
    }

    private String generateTicketId(String seatId, String eventId) {
        return "" + ("" + (Integer.parseInt(seatId) * Integer.parseInt(eventId))).hashCode();
    }
}
