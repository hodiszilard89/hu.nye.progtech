package hu.nye.progtech;


import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.repository.GameSaveWithJDBC;
import hu.nye.progtech.service.TablaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args)  {
        TablaService ts = new TablaService();
        Tabla tabla = new Tabla();
        tabla = ts.getRandomJatekTer();
        Connection con;


        new AnnotationConfigApplicationContext("hu.nye.progtech");

    }
}


