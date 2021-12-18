package interfaceek;

import model.Stat;
import model.Tabla;
import jakarta.xml.bind.JAXBException;

public interface GameSaveRepo {
    void save(Tabla tabla, String tablaNev);
    void saveStat(Stat stat, String statTabla);
    Tabla load(String tablaNev) throws JAXBException;
    Stat loadStat(String statTabla) throws JAXBException;
}
