package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.dao.AuditoriumDAO;
import oops.assignments.bookmyshow.objects.Auditorium;
import oops.assignments.bookmyshow.objects.Cinema;

public class AuditoriumRepository extends Repository<AuditoriumDAO, String> {

    private CinemaRepository cinemaRepository;

    public AuditoriumRepository(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public void save(Auditorium auditorium) {
        super.save(new AuditoriumDAO(auditorium), auditorium.getId());
    }

    public Auditorium getAuditoriumById(String id) {
        AuditoriumDAO auditoriumDAO = super.getById(id);
        Cinema cinema = cinemaRepository.getById(auditoriumDAO.getCinemaHallId());
        return new Auditorium(id, cinema, auditoriumDAO.getNumOfRows(), auditoriumDAO.getNumOfSeatsPerRow());
    }
}
