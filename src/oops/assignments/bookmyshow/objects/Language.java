package oops.assignments.bookmyshow.objects;

public enum Language {

    ENGLISH, HINDI, FARSI;

    public static Language getLanguage(String language) {
        for (Language item : values()) {
            if (item.toString().toLowerCase().equals(language.toLowerCase())) {
                return item;
            }
        }
        return null;
    }
}
