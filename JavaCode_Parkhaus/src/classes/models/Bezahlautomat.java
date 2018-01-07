package classes.models;

import interfaces.IBezahlautomat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import interfaces.*;

public class Bezahlautomat implements IBezahlautomat {
	private static Map<Calendar, Float> einnahmen;
	private static float preisProH = 1f;

	private float currentPayment;
	private float eingeworfen;

	public Bezahlautomat() {
		einnahmen = new HashMap<>();
	}

	@Override
	public float CalculatePayment(ITicket t, Calendar currentTime) {
		currentPayment = (currentTime.getTimeInMillis() - t.getDateEnter().getTimeInMillis()) / 3600000 * preisProH;
		return  currentPayment;
	}

	/*
	*	@return restgeld,
	 *  bei zu frühem pay() -> return = -1
	 */
	@Override
	public float pay(ITicket t) {
		float tmp;

		if(currentPayment > eingeworfen)
			return -1;
		eingeworfen -= currentPayment;

		t.setDatePayed(Calendar.getInstance());
		einnahmen.put(t.getDatePayed(), currentPayment);
		tmp = eingeworfen;
		//reset
		currentPayment = 0;
		eingeworfen = 0;

		return tmp;
	}

	/*
	 *	@return der fehlende betrag
	 */
	public float einwerfen(float money) {
		eingeworfen += money;
		if (currentPayment <= eingeworfen)
			return 0;
		return currentPayment - eingeworfen;
	}

	public static float getPreisProH() {
		return preisProH;
	}
	public static void setPreisProH(float preisProH) {
		Bezahlautomat.preisProH = preisProH;
	}
	public static Map<Calendar, Float> getEinnahmen() {
		return einnahmen;
	}
}
