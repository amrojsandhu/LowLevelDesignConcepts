package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.objects.Cinema;

public class CinemaRepository extends Repository<Cinema, String> {

    public void save(Cinema cinema) {
        super.save(cinema, cinema.getId());
    }
}
