package classes.templatMethod;

import classes.models.Bezahlautomat;

import java.util.Calendar;
import java.util.Map;

public class Tageseinnahmen extends Einnahmen  {
    @Override
    double getSpecificEinnahmen() {
        Map<Calendar, Float> einnahmen = Bezahlautomat.getEinnahmen();
        Calendar current = Calendar.getInstance();

        return einnahmen.keySet().stream()
                .filter(c -> c.get(Calendar.YEAR) == current.get(Calendar.YEAR)
                        && c.get(Calendar.DAY_OF_YEAR) == current.get(Calendar.DAY_OF_YEAR))
                .mapToDouble(c -> einnahmen.get(c)).sum();

    }
}
