package classes;

import interfaces.IBezahlautomat;
import java.util.Calendar;
import interfaces.*;

public class Bezahlautomat implements IBezahlautomat {
	private static float einnahmen = 0f;
	private static float preisProH = 1f;
	private float currentPayment;

	@Override
	public float CalculatePayment(ITicket t, Calendar currentTime) {
		t.setDatePayed(currentTime);
		currentPayment = (currentTime.getTimeInMillis() - t.getDateEnter().getTimeInMillis()) / 3600000 * preisProH;
		return  currentPayment;
	}

	@Override
	public float pay(float money) {
		currentPayment -= money;
		einnahmen += money;
		return currentPayment;
	}

	public static float getPreisProH() {
		return preisProH;
	}
	public static void setPreisProH(float preisProH) {
		Bezahlautomat.preisProH = preisProH;
	}
	public static float getEinnahmen() {
		return einnahmen;
	}
}
