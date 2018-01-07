package interfaces;


import java.util.Calendar;
import java.util.Map;

/**
 * Created by Lukas on 04.01.2018.
 */
public interface IParkhaus {

    float getPreisProH();
    int getFreieParkplaetze();
    ITicket ticketZiehen();
    void parken(ITicket ticket);
    Map<Calendar, Float> getEinnahmen();
    boolean leave(ITicket ticket, Calendar currentTime);
    IBezahlautomat getAutomat();
}
