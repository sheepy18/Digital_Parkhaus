package classes;

import interfaces.ITicket;

import java.util.Calendar;
import java.util.Date;

public class Ticket implements ITicket {
	private int ID;

	private boolean abo;

	private Calendar date;  //Erstellungsdatum
	private Calendar payDate; //Bezahldatum


	@Override
	public void setID(int ID) {
		this.ID = ID;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void setDateEnter(Calendar date) {
		this.date = date;
	}

	@Override
	public Calendar getDateEnter() {
		return date;
	}

	@Override
	public void setDatePayed(Calendar date) {
		payDate = date;
	}

	@Override
	public Calendar getDatePayed() {
		return payDate;
	}

	@Override
	public void setAbo(boolean Abo) {
		this.abo = Abo;
	}

	@Override
	public boolean getAbo() {
		return abo;
	}
}
