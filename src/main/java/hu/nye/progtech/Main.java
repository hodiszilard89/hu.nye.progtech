package hu.nye.progtech;


import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.repository.GameSaveWithJDBC;
import hu.nye.progtech.service.TablaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        TablaService ts = new TablaService();
        Tabla tabla = new Tabla();
        tabla = ts.getRandomJatekTer();
        Connection con;

//        con= DriverManager.getConnection("jdbc:h2:tcp://localhost/./test", "sa", "admin");
//       // new GameSaveWithJDBC(con).save(tabla,tabla,tabla);
//        Tabla tabla2=new GameSaveWithJDBC(con).loadTabla("AITABLA");
//        for(int i=0; i<10; i++) {
//            tabla2.sorKiIratas(i);
//            System.out.print("\n");
//            }
        new AnnotationConfigApplicationContext("hu.nye.progtech");

        // new MainController().start();
    }
}


