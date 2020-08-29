package oops.assignments.bookmyshow.services;

import oops.assignments.bookmyshow.objects.*;
import oops.assignments.bookmyshow.repository.*;
import oops.assignments.bookmyshow.sro.Event;

import java.util.List;

public class AdminService {

    private CinemaHallRepository cinemaHallRepository;
    private AuditoriumRepository auditoriumRepository;
    private MovieRepository movieRepository;
    private SeatingGridRepository seatingGridRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;

    public AdminService(CinemaHallRepository cinemaHallRepository, AuditoriumRepository auditoriumRepository,
                        MovieRepository movieRepository, SeatingGridRepository seatingGridRepository,
                        ShowRepository showRepository, UserRepository userRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
        this.seatingGridRepository = seatingGridRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
    }

    public void generateDummyData() {
        User user1 = new User("1", "Vader", "98888989989");
        User user2 = new User("2", "Skywalker", "98888989982");
        User user3 = new User("3", "Kenobi", "98888989981");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        System.out.println("Created Users: " + user1.getName() + ", " + user2.getName() + ", " + user3.getName());

        CinemaHall cinemaHall = new CinemaHall("1", "DeathStar", "Galaxy far away");
        cinemaHallRepository.save(cinemaHall);
        System.out.println("Created Cinema Hall at: " + cinemaHall.getCity());

        Auditorium auditorium1 = new Auditorium("A1", cinemaHall, 5, 5);
        Auditorium auditorium2 = new Auditorium("A2", cinemaHall, 5, 4);
        auditoriumRepository.save(auditorium1);
        auditoriumRepository.save(auditorium2);
        System.out.println("Created Auditoriums: " + auditorium1.getId() + ", " + auditorium2.getId());

        Movie movie1 = new Movie("1", "Star Wars: IX", Genre.SCIFI, Language.FARSI, new String[]{"Han Solo"});
        Movie movie2 = new Movie("2", "Star Wars: X", Genre.SCIFI, Language.FARSI, new String[]{"Man Solo"});
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        System.out.println("Created Movies: " + movie1.getName() + ", " + movie2.getName());

        Boolean[][] grid1 = new Boolean[][]{
                {null, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {null, false, false, false, false}
        };

        Boolean[][] grid2 = new Boolean[][]{
                {false, false, false, false},
                {null, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        SeatingGrid seatingGrid1 = new SeatingGrid("1", auditorium1.getNumOfRows(), auditorium1.getNumOfSeatsPerRow(), grid1);
        SeatingGrid seatingGrid2 = new SeatingGrid("2", auditorium2.getNumOfRows(), auditorium2.getNumOfSeatsPerRow(), grid2);
        seatingGridRepository.save(seatingGrid1);
        seatingGridRepository.save(seatingGrid2);
        System.out.println("Created SeatingGrids: " + seatingGrid1.getId() + ", " + seatingGrid2.getId());

        Show show1 = new Show("1", 1609459199L, 300, movie1, seatingGrid1, auditorium1);
        Show show2 = new Show("2", 1577836800L, 8000, movie2, seatingGrid2, auditorium2);
        Show show3 = new Show("3", 1577836800L, 340, movie1, seatingGrid1, auditorium1);
        showRepository.save(show1);
        showRepository.save(show2);
        showRepository.save(show3);
        System.out.println("Created Shows: " + show1.getId() + ":" + show1.getMovie() + ", " + show2.getId() + ":"
                + show2.getMovie() + ", " + show3.getId() + ":" + show3.getMovie());
    }

    public Boolean addOrUpdateEvents(List<Event> events) {
        throw new UnsupportedOperationException();
    }

    public Boolean addLayout(boolean[][] layout, long theaterId) {
        throw new UnsupportedOperationException();
    }

}
