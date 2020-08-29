package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.objects.CinemaHall;

public class CinemaHallRepository extends Repository<CinemaHall, String> {

    public void save(CinemaHall cinemaHall) {
        super.save(cinemaHall, cinemaHall.getId());
    }
}
