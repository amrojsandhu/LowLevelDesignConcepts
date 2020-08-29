package oops.assignments.bookmyshow;

import oops.assignments.bookmyshow.repository.*;
import oops.assignments.bookmyshow.services.*;
import oops.assignments.bookmyshow.sro.Booking;
import oops.assignments.bookmyshow.sro.Event;
import oops.assignments.bookmyshow.sro.Filter;

import java.util.Arrays;
import java.util.List;

public class BookMyShowClient {

    public static void main(String[] args) {
        CinemaHallRepository cinemaHallRepository = new CinemaHallRepository();
        MovieRepository movieRepository = new MovieRepository();
        SeatingGridRepository seatingGridRepository = new SeatingGridRepository();
        UserRepository userRepository = new UserRepository();
        PaymentService paymentService = new PaymentService();
        AuditoriumRepository auditoriumRepository = new AuditoriumRepository(cinemaHallRepository);
        ShowRepository showRepository = new ShowRepository(movieRepository, seatingGridRepository, auditoriumRepository);
        TicketRepository ticketRepository = new TicketRepository(userRepository, showRepository);
        SearchService searchService = new SearchService(showRepository, movieRepository);
        AdminService adminService = new AdminService(cinemaHallRepository, auditoriumRepository, movieRepository,
                seatingGridRepository, showRepository, userRepository);
        BookingService bookingService = new BookingService(showRepository, userRepository, ticketRepository,
                seatingGridRepository, paymentService);

        System.out.println("Calling Admin to generate data...");
        adminService.generateDummyData();
        System.out.println();

        Filter filter = new Filter("Star Wars: IX", null, null, null);
        System.out.println("Searching events with title: " + filter.getTitle());
        List<Event> events = searchService.fetchEvents(filter);
        System.out.println("Events with title: " + filter.getTitle() + " are:\n" + Arrays.toString(events.toArray()));
        System.out.println();

        String bookId1 = bookingService.bookEvent("11", "1", "1", "1");
        String bookId15 = bookingService.bookEvent("11", "1", "1", "1");
        String bookId2 = bookingService.bookEvent("12", "2", "1", "1");
        String bookId3 = bookingService.bookEvent("12", "1", "1", "2");
        String bookId4 = bookingService.bookEvent("13", "2", "1", "2");
        System.out.println("BookedIds: " + bookId1 + ", " + bookId2 + ", " + bookId3 + ", " + bookId4 + ", " + bookId15);
        System.out.println();

        String bookingId = bookId1 != null ? bookId1 : bookId2;
        System.out.println("Fetching booking for bookingId: " + bookingId);
        Booking booking = bookingService.fetchBooking(bookingId);
        System.out.println(booking);
    }
}
