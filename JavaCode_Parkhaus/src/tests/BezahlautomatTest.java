package tests;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class BezahlautomatTest {

	Bezahlautomat b;
	Ticket t1;
	Calendar d1, d2;
	float f1;
	
	@Before
	void setUp() {
		b = new Bezahlautomat(); 
		
		d1 = Calendar.getInstance();
		d2 = Calendar.getInstance();
		d2.add(Calendar.HOUR, 2);
		
		t1 = new Ticket();
		t1.setDateEnter(d1);
		
		

		
		f1 = 5.00f;
	}

	@Test
	void testpay() {
		//bei 1€ pro Stunde
		Assert.assertEquals(2f, b.pay(t1, f1, d2), 0.0001);
		Assert.assertEquals(d2, t1.getDatePayed());
	}

}
