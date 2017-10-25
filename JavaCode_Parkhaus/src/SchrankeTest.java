import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

class SchrankeTest {

	Schranke s;
	Ticket t1, t2, t3;
	Calendar d1, d2;
	
	@Before
	public void setUp() throws Exception {
		
		s = new Schranke(); 
		
		d1 = Calendar.getInstance();
		d2 = Calendar.getInstance();
		d2.add(Calendar.HOUR, 2);
		
		t1 = new Ticket();
		t1.setAbo(true);
		
		t2 = new Ticket();
		
		t3 = new Ticket();
		t3.setDateEnter(d1);
		t3.setDatePayed(d2);
	}
	
	@Test
	void testOpenEnterAbo() {
		assertTrue(s.openEnterAbo(t1));
		assertFalse(s.openEnterAbo(t2));
	}
	
	@Test
	void testOpenEnter() {
		assertTrue(s.openEnter());
		
		//Test Ticket erstellt?
	}

	@Test
	void testOpenExit() {
		assertTrue(s.openExit(t1));
		assertFalse(s.openExit(t2));
		assertTrue(s.openExit(t3));
		
		//Test Bezahlung zu lang her?
	}
}
