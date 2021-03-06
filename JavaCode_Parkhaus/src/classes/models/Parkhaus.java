package classes.models;

import interfaces.*;

import java.util.*;

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
    public Map<Calendar, Float> getEinnahmen() {
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

    public String toString() {
        String result = "Freie Parkplaetze: " + getFreieParkplaetze() + "\n\n";

        for(int j = 0; j < parkplaetze.length; j++) {
            result += (j+1) + ".Etage:\n";
           for(int i = 0; i < parkplaetze[0].length; i++) {
               result += (parkplaetze[j][i].getBelegt())? "+" : "#";
           }
            result += "\n";
        }
        return result;
    }

    public ITicket getTicket(int ID) {
        if(currentTickets.size() <= 0)
            return null;

        return currentTickets.stream()
                .filter(t -> t.getID() == ID)
                .findFirst()
                .get();
    }

}
