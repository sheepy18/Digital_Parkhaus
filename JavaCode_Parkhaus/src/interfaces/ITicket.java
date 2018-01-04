package interfaces;

import java.util.Calendar;

public interface ITicket {
	
	public void setID(int ID);
	public int getID();
	public void setDateEnter(Calendar date);
	public Calendar getDateEnter();
	public void setDatePayed(Calendar date);
	public Calendar getDatePayed();
	public void setAbo(boolean Abo);
	public boolean getAbo();
	void setParkplatz(IParkplatz parkplatz);
	IParkplatz getPartkplatz();
}
