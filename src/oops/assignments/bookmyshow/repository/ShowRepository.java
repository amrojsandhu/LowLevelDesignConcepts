package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.dao.ShowDAO;
import oops.assignments.bookmyshow.objects.Auditorium;
import oops.assignments.bookmyshow.objects.Movie;
import oops.assignments.bookmyshow.objects.SeatingGrid;
import oops.assignments.bookmyshow.objects.Show;

import java.util.*;

public class ShowRepository extends Repository<ShowDAO, String> {

    private MovieRepository movieRepository;
    private SeatingGridRepository seatingGridRepository;
    private AuditoriumRepository auditoriumRepository;

    public ShowRepository(MovieRepository movieRepository, SeatingGridRepository seatingGridRepository,
                          AuditoriumRepository auditoriumRepository) {
        this.movieRepository = movieRepository;
        this.seatingGridRepository = seatingGridRepository;
        this.auditoriumRepository = auditoriumRepository;
    }

    public void save(Show show) {
        super.save(new ShowDAO(show), show.getId());
    }

    public Show getShowById(String id) {
        ShowDAO showDAO = super.getById(id);
        return getShowFromDAO(showDAO);
    }

    private Show getShowFromDAO(ShowDAO showDAO) {
        Movie movie = movieRepository.getById(showDAO.getMovieId());
        SeatingGrid seatingGrid = seatingGridRepository.getById(showDAO.getSeatingGridId());
        Auditorium auditorium = auditoriumRepository.getAuditoriumById(showDAO.getAuditoriumId());
        return new Show(showDAO.getId(), showDAO.getTimeInEpoch(), showDAO.getCostPerSeat(), movie, seatingGrid,
                auditorium);
    }

    public List<Show> fetchByMovieIds(List<String> movieId) {
        List<ShowDAO> shows = super.getAll();
        List<Show> filteredShows = new ArrayList<>();
        for (ShowDAO show : shows) {
            if (movieId.contains(show.getMovieId())) {
                filteredShows.add(getShowFromDAO(show));
            }
        }
        return filteredShows;
    }

    public List<Show> fetchByPriceBetween(int minPrice, int maxPrice) {
        List<ShowDAO> shows = super.getAll();
        List<Show> filteredShows = new ArrayList<>();
        for (ShowDAO show : shows) {
            if (show.getCostPerSeat() >= minPrice && show.getCostPerSeat() <= maxPrice) {
                filteredShows.add(getShowFromDAO(show));
            }
        }
        return filteredShows;
    }
}