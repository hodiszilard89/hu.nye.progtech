package hu.nye.progtech.repository;

import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.sql.Connection;


public class GameSaveRep implements GameSaveRepoForXml {

//    private Connection con;
//
//    @Override
//    public void save(Tabla tabla, Stat stat) {
//
//    }
//
//    @Override
//    public Tabla loadTabla() {
//        return null;
//    }
//
//    @Override
//    public Stat loadStat() {
//        return null;
//    }
//
//    @Override
//    public void close() throws Exception {
//        con.close();
//    }


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
    public void saveStat(Stat stat, String statTabla) {

        try {
            JAXBContext context = JAXBContext.newInstance((Stat.class));
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            marshaller.marshal(stat,new File (statTabla));
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
