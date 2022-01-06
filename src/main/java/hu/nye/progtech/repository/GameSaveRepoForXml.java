package hu.nye.progtech.repository;

import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;
import jakarta.xml.bind.JAXBException;

public interface GameSaveRepoForXml {
    void save(Tabla tabla, String tablaNev);

    void saveStat(Stat stat, String statTabla);

    Tabla load(String tablaNev) throws JAXBException;

    Stat loadStat(String statTabla) throws JAXBException;
}
