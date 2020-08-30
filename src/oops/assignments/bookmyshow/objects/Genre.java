package oops.assignments.bookmyshow.objects;

public enum Genre {

    HORROR, ACTION, COMEDY, DRAMA, ROMANCE, SCIFI;

    public static Genre getGenre(String genre) {
        for (Genre item : values()) {
            if (item.toString().toLowerCase().equals(genre.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
}
