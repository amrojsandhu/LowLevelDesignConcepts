package oops.assignments.bookmyshow.objects;

public class Movie {

    private String id;
    private String name;
    private Genre genre;
    private Language language;
    private String[] cast;

    public Movie(String id, String name, Genre genre, Language language, String[] cast) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.cast = cast;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre.toString();
    }

    public String getLanguage() {
        return language.toString();
    }

    public String[] getCast() {
        return cast;
    }
}
