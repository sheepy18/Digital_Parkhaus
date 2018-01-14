package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.models.Multiton;

class MultitonTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetInstanceQuad() {
		Multiton m1 = Multiton.getInstance("Quad", 11f, 1f);
		Multiton m2 = Multiton.getInstance("Quad", 12f, 2f);
		assertEquals(1, m1.getGebuehr(), 0.001);
		assertEquals(1, m2.getGebuehr(), 0.001);
	}
	
	/*@Test(expected = IllegalArgumentException.class) 
	public void testIllegalArgumentException() { 
	      Multiton.getInstance("", 1f, 1f);
	}*/
	
	@Test
	public void testIllegalArgumentException() {
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Multiton.getInstance("", 1f, 1f);
	            });
	    assertThrows(IllegalArgumentException.class,
	            ()->{
	            	Multiton.getInstance("test", 1f, 1f);
	            });
	}


}
