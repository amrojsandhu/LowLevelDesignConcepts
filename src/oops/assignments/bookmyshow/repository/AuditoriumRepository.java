package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.dao.AuditoriumDAO;
import oops.assignments.bookmyshow.objects.Auditorium;
import oops.assignments.bookmyshow.objects.CinemaHall;

public class AuditoriumRepository extends Repository<AuditoriumDAO, String> {

    private CinemaHallRepository cinemaHallRepository;

    public AuditoriumRepository(CinemaHallRepository cinemaHallRepository) {
        this.cinemaHallRepository = cinemaHallRepository;
    }

    public void save(Auditorium auditorium) {
        super.save(new AuditoriumDAO(auditorium), auditorium.getId());
    }

    public Auditorium getAuditoriumById(String id) {
        AuditoriumDAO auditoriumDAO = super.getById(id);
        CinemaHall cinemaHall = cinemaHallRepository.getById(auditoriumDAO.getCinemaHallId());
        return new Auditorium(id, cinemaHall, auditoriumDAO.getNumOfRows(), auditoriumDAO.getNumOfSeatsPerRow());
    }
}
