package interfaceek;

import domain.Tabla;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlGameSaveRep implements GameSaveRepo{

    @Override
    public void save(Tabla tabla, String tablaNev) {

        try {
            JAXBContext context = JAXBContext.newInstance((Tabla.class));
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            marshaller.marshal(tabla,new File (tablaNev));
        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }

    @Override
    public Tabla load(String tablaNev) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance((Tabla.class));
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Tabla) unmarshaller.unmarshal(new File(tablaNev));

    }
}
