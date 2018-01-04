package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import classes.Parkplatz;
import interfaces.IParkplatz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import interfaces.ITicket;
import classes.Ticket;

public class TicketTest {

	private ITicket t1;
	private Calendar date;
	
	@Before
	public void setUp() {
		date = Calendar.getInstance();
		t1 = new Ticket(date);
	}
	
	@Test
	public void testsetgetID() {
		t1.setID(1);
		Assert.assertEquals(1, t1.getID());
	}
	
	@Test
	public void testsetgetDateEnter() {
		t1.setDateEnter(date);
		Assert.assertEquals(date, t1.getDateEnter());
	}
	
	@Test
	public void testsetgetDatePayed() {
		t1.setDatePayed(date);
		Assert.assertEquals(date, t1.getDatePayed());
	}
	
	@Test
	public void testsetgetAbo() {
		t1.setAbo(true);
		assertTrue(t1.getAbo());
		t1.setAbo(false);
		assertFalse(t1.getAbo());
	}


	@Test
	public void Parkplatz() {
		IParkplatz p1, p2;
		p1 = new Parkplatz();
		p2 = new Parkplatz();

		t1.setParkplatz(p1);
		assertEquals(1, t1.getPartkplatz().getID());
		assertEquals(true, t1.getPartkplatz().getBelegt());
	}
}
