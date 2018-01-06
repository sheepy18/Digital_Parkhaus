package classes.view;

import classes.controller.Eingabecontroller;

public abstract class View {

    protected Eingabecontroller controller;

    public View(Eingabecontroller control) {
        this.controller = control;
    }

    public String toString() {
        return controller.getParkhaus().toString();
    }

    //input optionen für entsprechende sicht
    public abstract String options();

    public void chooseInput(char input) {

    }
}
