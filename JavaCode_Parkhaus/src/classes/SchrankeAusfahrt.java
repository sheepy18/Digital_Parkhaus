package classes;

import interfaces.ITicket;

import java.util.Calendar;

/**
 * Created by Lukas on 04.01.2018.
 */
public class SchrankeAusfahrt extends Schranke {
    @Override
    public boolean openExit(ITicket t, Calendar actualTime) {
        //TODO den Kram vom Controller(Parkhaus) überprüfen lassen
        boolean bezahlZeit = false;
        if(t.getDatePayed() != null)
        {
            long bezahlt = t.getDatePayed().getTimeInMillis();
            long current = actualTime.getTimeInMillis();
            bezahlZeit =  (bezahlt + (3600000 / 3)) >= current; // 1 std = 3600000 milisek
        }
        setOpen(bezahlZeit || t.getAbo());
        return getIsOpen();
    }
}
