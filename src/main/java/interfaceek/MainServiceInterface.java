package interfaceek;


import domain.Pozicio;
import domain.Tabla;

public interface MainServiceInterface {
    void hajoLerakas(Tabla tabla, Pozicio poz, int hossz, boolean orinet);
    Tabla getTabla();
    boolean intToBool(int i);
}
