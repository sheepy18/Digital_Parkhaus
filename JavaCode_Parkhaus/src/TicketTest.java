

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TicketTest {

	Ticket t1;
	
	@Before
	public void setUp() throws Exception {
		t1 = new Ticket();
	}
	
	@Test
	public void testsetgetID() {
		t1.setID(1);
		assertEquals(1, t1.getID());
	}
	
	@Test
	public void testsetgetDateEnter() {
		Date date = new Date();
		t1.setDateEnter(date);
		assertEquals(date, t1.getDateEnter());
	}
	
	@Test
	public void testsetgetDatePayed() {
		Date date = new Date();
		t1.setDatePayed(date);
		assertEquals(date, t1.getDatePayed());
	}
	
	@Test
	public void testsetgetAbo() {
		t1.setAbo(true);
		assertTrue(t1.getAbo());
		t1.setAbo(false);
		assertFalse(t1.getAbo());
	}

}
