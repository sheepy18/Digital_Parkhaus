package classes.templatMethod;

public abstract class Einnahmen {


    float getEinnahmen(){
        return getSpecificEinnahmen();
    }

  abstract float getSpecificEinnahmen();
}
