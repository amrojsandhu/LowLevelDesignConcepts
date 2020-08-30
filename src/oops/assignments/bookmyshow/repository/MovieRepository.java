package oops.assignments.bookmyshow.repository;

import oops.assignments.bookmyshow.objects.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository extends Repository<Movie, String> {

    public void save(Movie movie) {
        super.save(movie, movie.getId());
    }

    public List<Movie> fetchByMoviesTitleRegex(String title) {
        List<Movie> movies = super.getAll();
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getName().matches(title)) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

    public List<Movie> fetchByGenre(String genre) {
        List<Movie> movies = super.getAll();
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if(movie.getGenre().equalsIgnoreCase(genre))
                filteredMovies.add(movie);
        }
        return filteredMovies;
    }

    public List<Movie> fetchByLanguage(String language) {
        List<Movie> movies = super.getAll();
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if(movie.getLanguage().equalsIgnoreCase(language))
                filteredMovies.add(movie);
        }
        return filteredMovies;
    }
}
