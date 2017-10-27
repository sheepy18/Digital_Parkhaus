package interfaces;

import java.util.Calendar;
import classes.Ticket;

public interface ISchranke {
	public boolean openEnterAbo(Ticket t);		
	public boolean openEnter();					//classes.Ticket erstellen
	public boolean openExit(Ticket t, Calendar actualTime);
}
