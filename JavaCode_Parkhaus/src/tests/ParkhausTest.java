package tests;

import classes.Parkhaus;
import interfaces.IParkhaus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkhausTest {

    IParkhaus parkhaus;

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
}
