package classes.templatMethod;


import classes.models.Bezahlautomat;

import java.util.Calendar;
import java.util.Map;

public abstract class Einnahmen {

    double getEinnahmen(){
        return getSpecificEinnahmen(Bezahlautomat.getEinnahmen(), Calendar.getInstance());
    }

  abstract double getSpecificEinnahmen(Map<Calendar, Float> einnahmen, Calendar current);
}
