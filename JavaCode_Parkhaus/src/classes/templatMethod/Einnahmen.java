package classes.templatMethod;



public abstract class Einnahmen {

    double getEinnahmen(){
        return getSpecificEinnahmen();
    }

  abstract double getSpecificEinnahmen();
}
