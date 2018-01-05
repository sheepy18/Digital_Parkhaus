package interfaces;


/**
 * Created by Lukas on 04.01.2018.
 */
public interface IParkhaus {

    float getPreisProH();
    int getFreieParkplaetze();
    ITicket ticketZiehen();
    void parken(ITicket ticket);
    float getEinnahmen();
    boolean leave(ITicket ticket);
    IBezahlautomat getAutomat();
}
