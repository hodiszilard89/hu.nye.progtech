package hu.nye.progtech.repository;

import java.io.File;

import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.model.Stat;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;



public class GameSaveWithXml implements GameSaveRepoForXml {


    @Override
    public void save(Tabla tabla, String tablaNev) {

        try {
            JAXBContext context = JAXBContext.newInstance((Tabla.class));
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(tabla, new File(tablaNev));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveStat(Stat stat, String statTabla) {

        try {
            JAXBContext context = JAXBContext.newInstance((Stat.class));
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(stat, new File(statTabla));
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

    @Override
    public Stat loadStat(String statTabla) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance((Stat.class));
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Stat) unmarshaller.unmarshal(new File(statTabla));
    }


}
