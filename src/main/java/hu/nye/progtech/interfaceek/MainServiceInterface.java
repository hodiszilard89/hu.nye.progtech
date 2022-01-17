package hu.nye.progtech.interfaceek;

import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.model.Pozicio;


public interface MainServiceInterface {
    void hajoLerakas(Tabla tabla, Pozicio poz, int hossz, boolean orinet);

    Tabla getRandomJatekTer();

    boolean intToBool(int i);
}
