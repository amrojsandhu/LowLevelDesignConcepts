package oops.assignments.bookmyshow.services;

import oops.assignments.bookmyshow.objects.Movie;
import oops.assignments.bookmyshow.objects.Show;
import oops.assignments.bookmyshow.repository.MovieRepository;
import oops.assignments.bookmyshow.repository.ShowRepository;
import oops.assignments.bookmyshow.sro.Event;
import oops.assignments.bookmyshow.sro.Filter;

import java.util.*;

public class SearchService {

    private ShowRepository showRepository;
    private MovieRepository movieRepository;

    public SearchService(ShowRepository showRepository, MovieRepository movieRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
    }

    public List<Event> fetchEvents(Filter filter) {

        List<Movie> moviesByTitle = movieRepository.fetchByMoviesTitleRegex(filter.getTitle());
        List<Movie> moviesByGenre = movieRepository.fetchByGenre(filter.getGenre());
        List<Movie> moviesByLanguage = movieRepository.fetchByLanguage(filter.getLanguage());

        List<Movie> intersectionOfMovies = intersection(moviesByTitle, moviesByGenre, moviesByLanguage);

        List<String> filteredMovieIds = new ArrayList<>();
        if (intersectionOfMovies != null && !intersectionOfMovies.isEmpty())
            for (Movie movie : intersectionOfMovies) {
                filteredMovieIds.add(movie.getId());
            }

        List<Show> showsByMovie = null;
        if (!filteredMovieIds.isEmpty()) {
            showsByMovie = showRepository.fetchByMovieIds(filteredMovieIds);
        }

        List<Show> showsByPrice = showRepository.fetchByPriceBetween(filter.getPrice()[0], filter.getPrice()[1]);

        List<Show> intersectionOfShows = intersection(showsByMovie, showsByPrice, null);

        List<Event> events = new ArrayList<>();
        if (intersectionOfShows != null && !intersectionOfShows.isEmpty())
            for (Show show : intersectionOfShows) {
                events.add(new Event(show));
            }
        return events;
    }

    /**
     * @param eventId
     * @param theaterId is ignored. See assumptions in readme.
     * @return
     */
    public Boolean[][] fetchEventSeatLayout(String eventId, String theaterId) {
        Show show = showRepository.getShowById(eventId);
        return show.getSeatingGrid().getGrid();
    }

    private <T> List<T> intersection(List<T> list1, List<T> list2, List<T> list3) {
        List<T> p = null;
        if (list1 != null && !list1.isEmpty())
            p = list1;
        if (list2 != null && !list2.isEmpty())
            p = list2;
        if (list3 != null && !list3.isEmpty())
            p = list3;

        if (p == null)
            return p;

        if (list1 == null || list1.isEmpty())
            list1 = p;
        if (list2 == null || list2.isEmpty())
            list2 = p;
        if (list3 == null || list3.isEmpty())
            list3 = p;

        List<T> list = new ArrayList<>();
        for (T t : list1) {
            if (list2.contains(t) && list3.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

}
