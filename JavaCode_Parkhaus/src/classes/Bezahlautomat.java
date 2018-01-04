package classes;

import interfaces.IBezahlautomat;
import java.util.Calendar;
import interfaces.*;

public class Bezahlautomat implements IBezahlautomat {

	@Override
	public float pay(ITicket t, float money, Calendar actualTime) {
		// TODO Auto-generated method stub
		return (t.getDatePayed().getTime().getTime() - actualTime.getTime().getTime()) * 1.f;
	}
}
