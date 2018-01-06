package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import classes.models.SchrankeAusfahrt;
import classes.models.SchrankeEinfahrt;
import classes.models.Ticket;
import org.junit.Before;
import org.junit.Test;
import interfaces.*;

public class SchrankeTest {

	private ISchranke einfahrt, ausfahrt;
	private ITicket t1, t2, t3;
	private Calendar d1, d2, d3;

	@Before
	public void setUp()  {
		
		einfahrt = new SchrankeEinfahrt();
		ausfahrt = new SchrankeAusfahrt();

		d1 = Calendar.getInstance();
		d2 = Calendar.getInstance();
		d2.add(Calendar.HOUR, 2);
		d2.setTimeInMillis(d2.getTimeInMillis() + 3600000 * 2);

		d3 = Calendar.getInstance();
		d3.add(Calendar.HOUR, 3);
		d3.setTimeInMillis(d3.getTimeInMillis() + 3600000 * 3);

		t1 = new Ticket(d1);
		t1.setAbo(true);
		
		t2 = new Ticket(d2);
		
		t3 = new Ticket(d1);
		t3.setDatePayed(d2);
	}
	
	@Test
	public void testOpenEnterAbo() {
		assertTrue(einfahrt.openEnterAbo(t1));
		assertFalse(einfahrt.openEnterAbo(t2));
	}
	
	@Test
	public void testOpenEnter() {
		assertTrue(einfahrt.openEnter());
		
		//Test classes.models.Ticket erstellt?

	}

	@Test
	public void testOpenExit() {

		//Abo
		assertTrue(ausfahrt.openExit(t1, d2));
		//nicht bezahlt
		assertFalse(ausfahrt.openExit(t2, d2));
		//bezahlt
		assertTrue(ausfahrt.openExit(t3, d2));
		//Bezahlung zu lang her
		assertFalse(ausfahrt.openExit(t3, d3));
	}
}
