package classes.view;

import classes.controller.Eingabecontroller;
import classes.models.Parkhaus;
import interfaces.IBezahlautomat;
import interfaces.ITicket;

import java.util.Calendar;
import java.util.Scanner;

public class CustomerView extends View {

    public CustomerView(Eingabecontroller control) {
       super(control);
    }
    @Override
    public String toString() {
        return super.toString() + "\n" + options();
    }

    @Override
    public String options() {
        return "";
    }

    public void chooseInput(char input) {
        super.chooseInput(input);
        int IDTicket;
        ITicket ticket = null;
        Scanner sc;
        Parkhaus parkhaus = controller.getParkhaus();
        switch (input)
        {
            case 'p': //parken
                ticket = parkhaus.ticketZiehen();
                if( ticket != null) {
                    System.out.print("\nIhre Ticketnummer: " + ticket.getID()+ "\n");
                }
                else {
                    //TODO fehlerausgabe parken nicht möglich
                }
                break;
            case 't': //ticket
                sc = new Scanner(System.in);
                System.out.print("\nGeben Sie Ihre Ticketnummer ein: \n");
                IDTicket = sc.nextInt();
                ticket = parkhaus.getTicket(IDTicket);
                if (ticket != null) {
                    System.out.print(ticket.toString()); //TODO toString in ticket überschreiben
                }
                else {
                    //TODO fehlerausgabe kein ticket mit id gefunden
                }
                break;
            case 'b': //bezahlen
                IBezahlautomat automat = parkhaus.getAutomat();
                sc = new Scanner(System.in);
                IDTicket = sc.nextInt();

                ticket = parkhaus.getTicket(IDTicket);

                float money = automat.CalculatePayment(ticket, Calendar.getInstance());
                do{
                    System.out.println("\nEs fehlen noch " + money + " Euro, bitte werfen Sie das geld ein: ");
                    money = sc.nextFloat();
                    money = automat.einwerfen(money);
                }
                while( money > 0);
                float rueckgeld = automat.pay(ticket);
                System.out.println("\nTicket erfolgreich bezahlt!");
                if(rueckgeld > 0) {
                    System.out.println("Sie kriegen " + rueckgeld +" Euro zurueck");
                }
                break;
            case 'v': //verlassen
                sc = new Scanner(System.in);
                System.out.print("\nGeben Sie Ihre Ticketnummer ein: \n");
                IDTicket = sc.nextInt();
                ticket = parkhaus.getTicket(IDTicket);

                if(ticket != null){
                    parkhaus.leave(ticket, Calendar.getInstance());
                } else {
                    //TODO fehlerausgabe kein ticket mit id gefunden
                }
                break;
            default:
                //TODO fehlerausgabe nicht richtige eingabe
        }
    }
}
