package classes.controller;

import classes.models.Parkhaus;
import classes.view.CustomerView;
import classes.view.View;
import interfaces.ITicket;

import java.util.Scanner;

public class Eingabecontroller {


    private Parkhaus parkhaus;
    private View menu;

    public Eingabecontroller() {
        parkhaus = new Parkhaus(3, 20);
        menu = new CustomerView(this);
    }

    public Parkhaus getParkhaus() {
        return parkhaus;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print(loadView());

        String input = sc.next();
        chooseInput(input.toCharArray()[0]);
    }

    public void clear() {
        for(int i = 0; i < 1000; i++)
            System.out.println("");
    }

    public String loadView() {
        return menu.toString();
    }

    public void setView(View menu) {
        this.menu = menu;
    }

    public void chooseInput(char input) {
        ITicket ticket = null;
        switch (input)
        {
            case 'p':
                ticket = parkhaus.ticketZiehen();
                if( ticket != null) {
                    System.out.print("Ihre Ticketnummer: " + ticket.getID()+ "\n");
                }
                else {
                    //TODO fehlerausgabe parken nicht möglich
                }
                break;
            case 't':
                int IDTicket;
                Scanner sc = new Scanner(System.in);
                IDTicket = sc.nextInt();
                ticket = parkhaus.getTicket(IDTicket);
                if (ticket != null) {
                    ticket.toString(); //TODO toString in ticket überschreiben
                }
                else {
                    //TODO fehlerausgabe kein ticket mit id gefunden
                }
                break;

            default:
                //TODO fehlerausgabe nciht richtige eingabe
        }
    }
}
