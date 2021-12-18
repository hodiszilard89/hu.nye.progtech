package interfaceek;


import model.Pozicio;
import model.Tabla;

public interface MainServiceInterface {
    void hajoLerakas(Tabla tabla, Pozicio poz, int hossz, boolean orinet);
    Tabla getRandomJatekTer();
    boolean intToBool(int i);
}
