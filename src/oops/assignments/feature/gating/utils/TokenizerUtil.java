package oops.assignments.feature.gating.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenizerUtil {

    private final static String splitterRegex = "([^\"]\\S*|\".+?\")\\s*";

    public static String[] tokenize(String string) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile(splitterRegex).matcher(string);
        while (m.find()) {
            list.add(m.group(1));
        }
        return list.toArray(new String[0]);
    }

}
