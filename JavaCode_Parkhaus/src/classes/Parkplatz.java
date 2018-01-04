package classes;

import interfaces.IParkplatz;

/**
 * Created by Lukas on 04.01.2018.
 */
public class Parkplatz implements IParkplatz {
    private static int IDCounter = 0;
    private int ID;
    private boolean belegt;

    public Parkplatz() {
        ID = ++IDCounter;
    }

    @Override
    public void setBelegt(boolean belegt) {
        this.belegt = belegt;
    }

    @Override
    public boolean getBelegt() {
        return belegt;
    }

    @Override
    public int getID() {
        return ID;
    }
}
