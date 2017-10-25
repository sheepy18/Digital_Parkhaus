import java.util.Calendar;

public interface IBezahlautomat {
	public float pay(Ticket t, float money, Calendar actualTime);
}
