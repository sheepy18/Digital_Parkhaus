package interfaces;

import java.util.Calendar;

public interface ISchranke {
	 boolean openEnterAbo(ITicket t);
	 boolean openEnter();					//classes.models.Ticket erstellen
	 boolean openExit(ITicket t, Calendar actualTime);
	void close();
}
