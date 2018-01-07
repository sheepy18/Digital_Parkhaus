package classes.templatMethod;

import java.util.Calendar;
import java.util.Map;

public class MonatsEinnahmen extends Einnahmen  {
    @Override
    double getSpecificEinnahmen(Map<Calendar, Float> einnahmen, Calendar current) {
        return 0;
    }
}
