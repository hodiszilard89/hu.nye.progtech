package hu.nye.progtech;


import hu.nye.progtech.controller.MainController;
import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.repository.GameSaveRep;
import hu.nye.progtech.service.TablaService;
import jakarta.xml.bind.JAXBException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) throws JAXBException {

        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.nye.progtech");
        new MainController();
//        new GameSaveRep().save(new Tabla(new TablaService().getNewTabla()),"proba.xml");
    }
}


