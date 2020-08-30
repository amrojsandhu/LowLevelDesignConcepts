package oops.assignments.bookmyshow;

import oops.assignments.bookmyshow.repository.*;
import oops.assignments.bookmyshow.services.*;
import oops.assignments.bookmyshow.sro.Event;
import oops.assignments.bookmyshow.sro.Filter;

import java.util.*;
import java.util.concurrent.*;

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

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            final String bookId1 = bookingService.bookEvent("11", "1", "1", "1");
            if (bookId1 != null)
                System.out.println("Booked seating with details: " + bookingService.fetchBooking(bookId1));
        });
        executor.execute(() -> {
            final String bookId1 = bookingService.bookEvent("11", "1", "1", "1");
            if (bookId1 != null)
                System.out.println("Booked seating with details: " + bookingService.fetchBooking(bookId1));
        });
        executor.execute(() -> {
            final String bookId1 = bookingService.bookEvent("12", "2", "1", "1");
            if (bookId1 != null)
                System.out.println("Booked seating with details: " + bookingService.fetchBooking(bookId1));
        });
        executor.execute(() -> {
            final String bookId1 = bookingService.bookEvent("13", "2", "1", "1");
            if (bookId1 != null)
                System.out.println("Booked seating with details: " + bookingService.fetchBooking(bookId1));
        });
        executor.execute(() -> {
            final String bookId1 = bookingService.bookEvent("13", "2", "1", "1");
            if (bookId1 != null)
                System.out.println("Booked seating with details: " + bookingService.fetchBooking(bookId1));
        });
        executor.shutdown();

    }

}
