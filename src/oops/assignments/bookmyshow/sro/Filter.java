package oops.assignments.bookmyshow.sro;

public class Filter {

    private String title;
    private String genre;
    private String language;
    private int[] price = new int[]{0, 0};

    public Filter(String title, String genre, String language, String price) {
        this.title = title;
        this.genre = genre;
        this.language = language;
        String[] priceSplit = price != null ? price.split(":") : null;
        if (priceSplit != null && priceSplit.length != 0) {
            this.price[0] = Integer.parseInt(priceSplit[0]);
            this.price[1] = Integer.parseInt(priceSplit[1]);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int[] getPrice() {
        return price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{\n");
        sb.append("\ttitle: ").append(title).append(",\n");
        sb.append("\tgenre: ").append(genre).append(",\n");
        sb.append("\tlanguage: ").append(language).append(",\n");
        sb.append("\tprice: ").append(price).append(",\n");
        sb.append('}');
        return sb.toString();
    }
}
