import java.util.Calendar;

public interface ISchranke {
	public boolean openEnterAbo(Ticket t);		
	public boolean openEnter();					//Ticket erstellen
	public boolean openExit(Ticket t, Calendar actualTime);
}
