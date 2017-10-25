

import java.util.Date;

public interface ITicket {
	
	public void setID(int ID);
	public int getID();
	public void setDateEnter(Date date);
	public Date getDateEnter();
	public void setDatePayed(Date date);
	public Date getDatePayed();
	public void setAbo(boolean Abo);
	public boolean getAbo();
	
}
