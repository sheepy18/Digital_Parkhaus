package classes.models;

import interfaces.ITicket;

import java.util.Calendar;

/**
 * Created by Lukas on 04.01.2018.
 */
public class SchrankeAusfahrt extends Schranke {
    @Override
    public boolean openExit(ITicket t, Calendar currentTime) {
        boolean bezahlZeit = false;
        if(t.getDatePayed() != null)
        {
            long bezahlt = t.getDatePayed().getTimeInMillis();
            long current = currentTime.getTimeInMillis();
            bezahlZeit =  (bezahlt + (3600000 / 3)) >= current; // 1 std = 3600000 milisek
        }
        setOpen(bezahlZeit || t.getAbo());
        return getIsOpen();
    }
}
