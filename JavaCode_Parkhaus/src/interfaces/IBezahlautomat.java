package interfaces;

import java.util.Calendar;
import classes.Ticket;

public interface IBezahlautomat {
	public float pay(ITicket t, float money, Calendar actualTime);
}
