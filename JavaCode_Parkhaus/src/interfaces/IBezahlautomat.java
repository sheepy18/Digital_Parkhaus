package interfaces;

import java.util.Calendar;

public interface IBezahlautomat {
	float CalculatePayment(ITicket t, Calendar actualTime);
	float pay(float money);
}
