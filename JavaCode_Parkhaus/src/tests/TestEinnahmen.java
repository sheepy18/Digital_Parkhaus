package tests;

import classes.models.Bezahlautomat;
import classes.templatMethod.Einnahmen;
import classes.templatMethod.Tageseinnahmen;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestEinnahmen {
    Bezahlautomat automat;

    Calendar[] dates;

    @Before
    public void setup() {
        Map<Calendar, Float> einnnahmen = new HashMap<>();
        automat = new Bezahlautomat();

        dates = new Calendar[]{
                Calendar.getInstance(),
                Calendar.getInstance(),
                Calendar.getInstance(),
                Calendar.getInstance(),
                Calendar.getInstance()
        };

        dates[0].set(2018, Calendar.DECEMBER, 28);
        dates[1].set(2018, Calendar.DECEMBER, 28);
        dates[2].set(2018, Calendar.DECEMBER, 25);
        dates[3].set(2018, Calendar.AUGUST, 25);
        dates[4].set(2018, Calendar.JANUARY, 6);

        float[] bezahlungen = {5, 10, 4, 3, 2};

        for(int i = 0; i < 5; i++) {
            einnnahmen.put(dates[i], bezahlungen[i]);
        }

        Bezahlautomat.setEinnahmen(einnnahmen);
    }

    @Test
    public void tagesEinnahmen() {
        Einnahmen einahmen = new Tageseinnahmen();
        assertEquals(15 , einahmen.getEinnahmen(), 0.001);
    }
}
