package hu.nye.progtech.repository;

import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.model.Stat;

public interface GameSaveRepoForJDBC {
    void save(Tabla tabla, Stat stat);
    Tabla loadTabla();
    Stat loadStat();
}
