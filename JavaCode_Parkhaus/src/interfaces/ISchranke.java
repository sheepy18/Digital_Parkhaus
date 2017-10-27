package interfaces;

import java.util.Calendar;
import classes.Ticket;

public interface ISchranke {
	public boolean openEnterAbo(ITicket t);
	public boolean openEnter();					//classes.Ticket erstellen
	public boolean openExit(ITicket t, Calendar actualTime);
}
