package tests;

import classes.models.Decorator;
import classes.models.Parkhaus;
import classes.models.ParkhausDecorator;
import interfaces.IBezahlautomat;
import interfaces.IParkhaus;
import interfaces.ITicket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;


public class XMLTest {
    IParkhaus parkhaus;
    ArrayList<ITicket> tickets = new ArrayList<>();
    Decorator decorator;

    @Before
    public void setup() {
        parkhaus = new Parkhaus(1, 10);
        tickets.add(parkhaus.ticketZiehen());
        ITicket currentTicket = tickets.get(0);
        IBezahlautomat bA = parkhaus.getAutomat();

        Calendar payed = Calendar.getInstance();
        payed.setTimeInMillis(payed.getTimeInMillis() + 3600000 * 2 );

        bA.CalculatePayment(currentTicket, payed);
        bA.einwerfen(1);
        bA.einwerfen(1);
        bA.pay(currentTicket);

        Calendar c = Calendar.getInstance();
        parkhaus.leave(currentTicket, c );

        //Persistierung
        decorator = new ParkhausDecorator((Parkhaus) parkhaus);
        decorator.toXmlFile();
    }

    @Test
    public void parkhausausxml() {
        parkhaus = new Parkhaus(23,4);
        decorator = new ParkhausDecorator((Parkhaus) parkhaus);
        parkhaus = decorator.fromXMLToParkhaus();
        assertEquals(10, parkhaus.getFreieParkplaetze());
    }
}
