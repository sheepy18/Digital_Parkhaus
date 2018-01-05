package tests;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import classes.*;
import interfaces.*;

import static org.junit.Assert.assertEquals;

public class BezahlautomatTest {
	private IBezahlautomat b;
	private ITicket t1;
	private Calendar d1, d2;
	private float f1;

	@Before
	public void setUp() {
		b = new Bezahlautomat(); 
		
		d1 = Calendar.getInstance();
		d2 = Calendar.getInstance();
		d2.setTimeInMillis(d2.getTimeInMillis() + 3600000 * 2);
		
		t1 = new Ticket(d1);
		t1.setDateEnter(d1);

		f1 = 5.00f;
	}

	@Test
	public void testpay() {
		//bei 1€ pro Stunde
		assertEquals(2f, b.CalculatePayment(t1, d2), 0.0001);
		assertEquals(0, b.einwerfen(2f), 0.01);
		assertEquals(0, b.einwerfen(100f), 0.01);
		assertEquals(100, b.pay(t1), 0.01);
		assertEquals(Calendar.getInstance(), t1.getDatePayed());
	}

}
