package interfaceek;

import domain.Tabla;
import jakarta.xml.bind.JAXBException;

public interface GameSaveRepo {
    void save(Tabla tabla, String tablaNev);
    Tabla load(String tablaNev) throws JAXBException;
}
