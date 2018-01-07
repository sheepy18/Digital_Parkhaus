package classes.templatMethod;

import java.util.Calendar;
import java.util.Map;

public class WochenEinnahmen extends Einnahmen {
    @Override
    double getSpecificEinnahmen(Map<Calendar, Float> einnahmen, Calendar current) {
        return einnahmen.keySet().stream()
                .filter(c -> c.get(Calendar.YEAR) == current.get(Calendar.YEAR)
                        && c.get(Calendar.WEEK_OF_YEAR) == current.get(Calendar.WEEK_OF_YEAR)
                        && c.get(Calendar.WEEK_OF_MONTH) == current.get(Calendar.WEEK_OF_MONTH)
                )
                .mapToDouble(c -> einnahmen.get(c)).sum();
    }
}
