package com.company.interfaceek;

import com.company.entity.Pozicio;
import com.company.entity.Tabla;

public interface MainServiceInterface {
    void hajoLerakas(Tabla tabla, Pozicio poz, int hossz, boolean orinet);
    Tabla getTabla();
    boolean intToBool(int i);
}
