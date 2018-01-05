package classes;

import interfaces.*;
import java.util.Calendar;

public abstract class Schranke implements ISchranke {
	private boolean isOpen;

	@Override
	public boolean openEnterAbo(ITicket t) {
		setOpen(t.getAbo());
		return isOpen;
	}

	@Override
	public boolean openEnter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openExit(ITicket t, Calendar actualTime) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setOpen(boolean open) {
		this.isOpen = open;
	}

	public boolean getIsOpen() {
		return isOpen;
	}

	public void close() {
		isOpen = false;
	}
}
