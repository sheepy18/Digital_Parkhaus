package classes;

import classes.controller.Eingabecontroller;

public class Main {

    public static void main(String[] args) {
       Eingabecontroller eingabe = new Eingabecontroller();
       eingabe.start();
       eingabe.speichern();
    }
}
