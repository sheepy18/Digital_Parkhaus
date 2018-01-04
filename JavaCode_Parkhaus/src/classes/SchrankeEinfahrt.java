package classes;

/**
 * Created by Lukas on 04.01.2018.
 */
public class SchrankeEinfahrt extends Schranke {
    @Override
    public boolean openEnter() {
        setOpen(true);
        return getIsOpen();
    }
}
