package classes.controller;

import classes.models.Parkhaus;
import classes.models.ParkhausDecorator;
import classes.view.CustomerView;
import classes.view.View;

import java.util.Scanner;

public class Eingabecontroller  {

    private Parkhaus parkhaus;
    private View menu;

    public Eingabecontroller() {
        parkhaus = new Parkhaus(3, 20);
        menu = new CustomerView(this);
    }

    public Eingabecontroller(boolean fromFile) {
        if(fromFile) {
            parkhaus = new ParkhausDecorator(parkhaus).fromXMLToParkhaus();
            menu = new CustomerView(this);
        } else {
            parkhaus = new Parkhaus(3, 20);
            menu = new CustomerView(this);
        }
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
       menu.chooseInput(input);
    }

    public void speichern() {
        new ParkhausDecorator(parkhaus).toXmlFile();
    }

    public void update() {
        start();
    }
}
