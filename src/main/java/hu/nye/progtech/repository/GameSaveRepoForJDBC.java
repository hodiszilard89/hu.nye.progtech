package hu.nye.progtech.repository;

import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.model.Stat;

import java.sql.SQLException;

public interface GameSaveRepoForJDBC {

    void save(Tabla jatekosTabla, Tabla sajatLoves, Tabla aiTabla) throws SQLException;

    Tabla loadTabla(String tablaNev);

    Stat loadStat();

    void delete() throws SQLException;
}
