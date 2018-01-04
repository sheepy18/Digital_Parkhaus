package tests;

import classes.Parkplatz;
import interfaces.IParkplatz;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lukas on 04.01.2018.
 */
public class ParkplatzTest {

    private IParkplatz[] plaetze;

    @Before
    public void setup() {
        plaetze = new IParkplatz[] {new Parkplatz(), new Parkplatz(), new Parkplatz()};
    }

    @Test
    public void ID() {
        assertEquals(1, plaetze[0].getID());
        assertEquals(2, plaetze[1].getID());
        assertEquals(3, plaetze[2].getID());
    }

    @Test
    public void Belegt() {
        assertEquals(false, plaetze[0].getBelegt());
        assertEquals(false, plaetze[1].getBelegt());
        assertEquals(false, plaetze[2].getBelegt());

        Arrays.stream(plaetze).forEach(p -> p.setBelegt(true));

        assertEquals(true, plaetze[0].getBelegt());
        assertEquals(true, plaetze[1].getBelegt());
        assertEquals(true, plaetze[2].getBelegt());
    }
}
