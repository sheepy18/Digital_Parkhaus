package classes.view;

import classes.controller.Eingabecontroller;

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
}
