package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import interfaces.ITicket;
import classes.Ticket;


public class TicketTest {

	ITicket t1;
	Calendar date;
	
	@Before
	public void setUp() throws Exception {
		t1 = new Ticket();
		date = Calendar.getInstance();
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

}
