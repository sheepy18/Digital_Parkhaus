package classes.view;

import classes.controller.Eingabecontroller;

public class ManagerView extends  View {

    public ManagerView(Eingabecontroller control) {
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
    }
}
