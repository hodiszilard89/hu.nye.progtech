package hu.nye.progtech;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        try {
            DriverManager.getConnection("jdbc:h2:tcp://localhost/./test", "sa", "admin");
        } catch (SQLException e) {
            System.out.println("Sikertelen");
        }


        new AnnotationConfigApplicationContext("hu.nye.progtech");

        // new MainController().start();
    }
}


