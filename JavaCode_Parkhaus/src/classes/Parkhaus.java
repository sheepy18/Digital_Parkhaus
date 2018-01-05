package classes;

import interfaces.IParkhaus;
import interfaces.IParkplatz;
import interfaces.ITicket;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Deque;

public class Parkhaus implements IParkhaus {

    private IParkplatz[][] parkplaetze;
    private Deque<ITicket> currentTickets;

    public Parkhaus(int etagen, int platzProEtage) {
        currentTickets = new ArrayDeque<>();
        parkplaetze = new IParkplatz[etagen][platzProEtage];
        for(int i = 0; i < etagen; i++) {
            for(int x = 0; x < platzProEtage; x++) {
                parkplaetze[i][x] = new Parkplatz();
            }
        }
    }

    @Override
    public float getPreisProH() {
        return Bezahlautomat.getPreisProH();
    }

    @Override
    public int getFreieParkplaetze() {
        return Arrays.stream(parkplaetze)
                .mapToInt(p -> Arrays.stream(p)
                        .mapToInt(park -> ((park.getBelegt())? 0 : 1))
                        .sum())
                .sum();
    }

    @Override
    public ITicket ticketZiehen() {
        if(getFreieParkplaetze() == 0)
            return  null;

        Ticket t = new Ticket(Calendar.getInstance());
        parken(t);
        currentTickets.add(t);
        return t;
    }

    @Override
    public void parken(ITicket ticket) {
        IParkplatz p = getNextAvailable();

        if (p == null)
            return;
        ticket.setParkplatz(p);
    }

    @Override
    public float getEinnahmen() {
        return Bezahlautomat.getEinnahmen();
    }

    private IParkplatz getNextAvailable() {
        IParkplatz p;
        for(int i = 0; i < parkplaetze.length; i++) {
            for(int x = 0; x < parkplaetze[0].length; x++) {
                p = parkplaetze[i][x];
                if(!p.getBelegt())
                    return p;
            }
        }
        return null;
    }
}
