package tests;

import classes.models.Decorator;
import classes.models.Parkhaus;

import interfaces.IBezahlautomat;
import interfaces.IParkhaus;
import interfaces.ITicket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkhausTest {

    IParkhaus parkhaus;
    ArrayList<ITicket> tickets = new ArrayList<>();
    Decorator decorator;

    @Before
    public void setup(){
        parkhaus = new Parkhaus(3, 50);
    }

    @Test
    public void freieParkplaetze() {
        assertEquals(150, parkhaus.getFreieParkplaetze());
        parkhaus = new Parkhaus(4, 20);
        assertEquals(80, parkhaus.getFreieParkplaetze());
        parkhaus = new Parkhaus(10, 200);
        assertEquals(2000, parkhaus.getFreieParkplaetze());
        parkhaus = new Parkhaus(1, 1000);
        assertEquals(1000, parkhaus.getFreieParkplaetze());
    }

    @Test
    public void ticketZiehen() {
        parkhaus = new Parkhaus(3, 50);
        parkhaus.ticketZiehen();
        assertEquals(149, parkhaus.getFreieParkplaetze());

        for(int i = 0; i < 149; i++) {
            parkhaus.ticketZiehen();
        }
        assertEquals(0, parkhaus.getFreieParkplaetze());

        parkhaus.ticketZiehen();
        assertEquals(0, parkhaus.getFreieParkplaetze());
    }

    @Test
    public void ticketPayAndLeave() {

        parkhaus = new Parkhaus(3, 50);

        for(int i = 0; i < 150; i++) {
            tickets.add(parkhaus.ticketZiehen());
        }

        ITicket currentTicket = tickets.get(0);
        IBezahlautomat bA = parkhaus.getAutomat();
        Calendar payed = Calendar.getInstance();

        payed.setTimeInMillis(payed.getTimeInMillis() + 3600000 * 2 );

        bA.CalculatePayment(currentTicket, payed);
        assertEquals(-1, bA.pay(currentTicket), 0.01);

        parkhaus.leave(tickets.get(0),Calendar.getInstance());
        assertEquals(0, parkhaus.getFreieParkplaetze());

        assertEquals(1, bA.einwerfen(1), 0.01);
        bA.pay(currentTicket);
        assertEquals(0, bA.einwerfen(1), 0.01);
        bA.pay(currentTicket);
        parkhaus.leave(tickets.get(0),Calendar.getInstance());
        assertEquals(1, parkhaus.getFreieParkplaetze());

        while(!tickets.isEmpty()){
            parkhaus.leave(tickets.remove(0),Calendar.getInstance());
        }
        assertEquals(1, parkhaus.getFreieParkplaetze());
        assertEquals(0, tickets.size());
    }

    @Test
    public void bezahlungZuLang() {
        parkhaus = new Parkhaus(1, 10);
        tickets.add(parkhaus.ticketZiehen());
        ITicket currentTicket = tickets.get(0);
        IBezahlautomat bA = parkhaus.getAutomat();

        Calendar payed = Calendar.getInstance();
        payed.setTimeInMillis(payed.getTimeInMillis() + 3600000 * 2 );

        bA.CalculatePayment(currentTicket, payed);
        assertEquals(1, bA.einwerfen(1), 0.01);
        assertEquals(0, bA.einwerfen(1), 0.01);
        bA.pay(currentTicket);

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(payed.getTimeInMillis()  + (3600000 / 3) + 1); // eine mili sekunde zu spät
        parkhaus.leave(currentTicket, c );


    }


}
