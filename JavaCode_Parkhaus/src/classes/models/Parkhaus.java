package classes.models;

import interfaces.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Deque;

public class Parkhaus implements IParkhaus {

    private IParkplatz[][] parkplaetze;
    private Deque<ITicket> currentTickets;
    private Deque<ISchranke> schranken;
    private Deque<IBezahlautomat> automaten;

    public Parkhaus() {

    }

    public Parkhaus(int etagen, int platzProEtage) {
        currentTickets = new ArrayDeque<>();
        schranken =  new ArrayDeque<>();
        automaten =  new ArrayDeque<>();

        parkplaetze = new IParkplatz[etagen][platzProEtage];

        for(int i = 0; i < etagen; i++) {
            for(int x = 0; x < platzProEtage; x++) {
                parkplaetze[i][x] = new Parkplatz();
            }
        }

        addSchranke(new SchrankeEinfahrt());
        addSchranke(new SchrankeAusfahrt());
        addAutomat(new Bezahlautomat());
    }

    public void addSchranke(ISchranke schranke) {
        schranken.add(schranke);
    }

    public void addAutomat(IBezahlautomat automat) {
        automaten.add(automat);
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

    @Override
    public boolean leave(ITicket ticket, Calendar currentTime) {
        if(ticket.getDatePayed() == null)
            return false;

        ISchranke schranke = schranken.stream().filter(s -> s instanceof SchrankeAusfahrt).findFirst().get();
        if(schranke.openExit(ticket, currentTime)) {
            currentTickets.remove(ticket);
            ticket.getPartkplatz().setBelegt(false);
            schranke.close();
            return true;
        }
        return false;
    }

    @Override
    public IBezahlautomat getAutomat() {
        return automaten.getFirst();
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
