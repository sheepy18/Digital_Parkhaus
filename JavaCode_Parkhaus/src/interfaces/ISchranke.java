package interfaces;

import java.util.Calendar;
import classes.Ticket;

public interface ISchranke {
	 boolean openEnterAbo(ITicket t);
	 boolean openEnter();					//classes.Ticket erstellen
	 boolean openExit(ITicket t, Calendar actualTime);
}
