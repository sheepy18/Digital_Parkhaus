package classes.templatMethod;

import java.util.Calendar;
import java.util.Map;

public class MonatsEinnahmen extends Einnahmen  {
    @Override
    double getSpecificEinnahmen(Map<Calendar, Float> einnahmen, Calendar current) {
        return einnahmen.keySet().stream()
                .filter(c -> c.get(Calendar.YEAR) == current.get(Calendar.YEAR)
                        && c.get(Calendar.MONTH) == current.get(Calendar.MONTH))
                .mapToDouble(c -> einnahmen.get(c)).sum();
    }
}
