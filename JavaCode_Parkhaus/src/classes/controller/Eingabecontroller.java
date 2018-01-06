package classes.controller;

import classes.models.Parkhaus;
import classes.view.CustomerView;
import classes.view.View;

public class Eingabecontroller {


    Parkhaus parkhaus;
    View menu;

    public Eingabecontroller() {
        parkhaus = new Parkhaus(3, 20);
        menu = new CustomerView(this);
    }

    public Parkhaus getParkhaus() {
        return parkhaus;
    }
}
