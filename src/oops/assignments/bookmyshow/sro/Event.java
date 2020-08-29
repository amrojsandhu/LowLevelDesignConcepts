package oops.assignments.bookmyshow.sro;

import oops.assignments.bookmyshow.objects.Show;
import oops.assignments.bookmyshow.services.TimeConverterUtils;

import java.util.*;

public class Event {

    private String eventId;
    private String screenId;
    private String title;
    private String genre;
    private String language;
    private ShowTimeVsPrice[] showTimePriceMap;

    public Event(Show show) {
        this.eventId = show.getId();
        this.screenId = show.getAuditorium().getId();
        ShowTimeVsPrice[] showTimeVsPriceMap = new ShowTimeVsPrice[1];
        showTimeVsPriceMap[0] = new ShowTimeVsPrice(show.getTimeInEpoch(), show.getCostPerSeat());
        this.showTimePriceMap = showTimeVsPriceMap;
        this.title = show.getMovie().getName();
        this.genre = show.getMovie().getGenre();
        this.language = show.getMovie().getLanguage();
    }

    public String getEventId() {
        return eventId;
    }

    public String getScreenId() {
        return screenId;
    }

    public List<String> getShowTimePriceMap() {
        List<String> timePriceAsList = new ArrayList<>();
        for (ShowTimeVsPrice showTimeVsPrice : this.showTimePriceMap) {
            timePriceAsList.add(showTimeVsPrice.toString());
        }
        return timePriceAsList;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{\n");
        sb.append("\teventId: ").append(eventId).append(",\n");
        sb.append("\tscreenId: ").append(screenId).append(",\n");
        sb.append("\tshowTimePriceMap: ").append(getShowTimePriceMap()).append(",\n");
        sb.append("\ttitle: ").append(title).append(",\n");
        sb.append("\tgenre: ").append(genre).append(",\n");
        sb.append("\tlanguage: ").append(language).append("\n");
        sb.append('}');
        return sb.toString();
    }

    class ShowTimeVsPrice {

        int timeInHourOfDay;
        int price;

        public ShowTimeVsPrice(Long timeInEpoch, int price) {
            this.timeInHourOfDay = TimeConverterUtils.getHourOfDayForEpoch(timeInEpoch);
            this.price = price;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("{\n");
            sb.append("\ttime: ").append(timeInHourOfDay).append(",\n");
            sb.append("\tprice: ").append(price).append("\n");
            sb.append('}');
            return sb.toString();
        }
    }
}
