package oops.assignments.bookmyshow.services;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeConverterUtils {

    public static int getHourOfDayForEpoch(Long timeInEpoch) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeInEpoch);
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        return cal.get(Calendar.HOUR_OF_DAY);
    }
}
