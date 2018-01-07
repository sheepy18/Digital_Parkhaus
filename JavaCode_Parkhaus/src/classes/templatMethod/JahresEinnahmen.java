package classes.templatMethod;

import java.util.Calendar;
import java.util.Map;

public class JahresEinnahmen extends Einnahmen {
    @Override
    double getSpecificEinnahmen(Map<Calendar, Float> einnahmen, Calendar current) {
        return einnahmen.keySet().stream()
                .filter(c -> c.get(Calendar.YEAR) == current.get(Calendar.YEAR))
                .mapToDouble(c -> einnahmen.get(c)).sum();
    }
}
