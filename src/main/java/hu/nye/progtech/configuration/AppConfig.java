package hu.nye.progtech.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import hu.nye.progtech.controller.MainController;
import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.model.Hajo;
import hu.nye.progtech.model.Mezo;
import hu.nye.progtech.model.Pozicio;
import hu.nye.progtech.repository.GameSaveWithJDBC;
import hu.nye.progtech.repository.GameSaveWithXml;
import hu.nye.progtech.service.FileService;
import hu.nye.progtech.service.Jatek;
import hu.nye.progtech.service.TablaService;
import hu.nye.progtech.service.UIInPutService;
import hu.nye.progtech.service.UIOutPutService;
import hu.nye.progtech.service.UjJatek;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    TablaService tablaService() {
        return new TablaService();
    }

    @Bean
    FileService fileService() {
        return new FileService();
    }

    @Bean
    UIOutPutService uiOutPutService() {
        return new UIOutPutService();
    }

    @Bean
    UIInPutService uiInPutService() {
        //Scanner in = new Scanner(System.in);
        return new UIInPutService();
    }

    @Bean
    Connection connection() throws SQLException {
        Connection conection = DriverManager.getConnection("jdbc:h2:tcp://localhost/./test", "sa", "admin");
        return conection;
    }

    @Bean
    GameSaveWithJDBC gameSaveRep(Connection connection) {
        return new GameSaveWithJDBC(connection);
    }
    /*
    @Bean
    GameSaveRep gameSaveRep(){
        return new GameSaveRep();
    }

    @Bean(initMethod = "start")
    MainController mainController(TablaService tablaService, FileService fileService,
                                  UIInPutService uiInPutService, GameSaveWithJDBC gameSaveWithJDBC) {

        return new MainController(tablaService, fileService, uiInPutService, gameSaveWithJDBC);
    }

     */

    @Bean
    GameSaveWithXml gameSaveWithXml() {
        return new GameSaveWithXml();
    }

    @Bean(initMethod = "start")
    MainController mainController(TablaService tablaService, FileService fileService,
                                  UIInPutService uiInPutService, GameSaveWithXml gameSaveWithXml) {

        return new MainController(tablaService, fileService, uiInPutService, gameSaveWithXml);
    }

    @Bean
    Pozicio pozicio() {
        return new Pozicio();
    }

    @Bean
    Mezo mezo(Pozicio pozicio) {
        boolean szabad = true;
        return new Mezo(pozicio, szabad);
    }

    @Bean
    Mezo[][] mezoTabla() {
        return new Mezo[10][10];
    }

    @Bean
    public Tabla tabla(Mezo[][] jatekter) {
        return new Tabla(jatekter);
    }

    @Bean
    public Hajo hajo(List<Pozicio> hajoElemek, Pozicio kezdoPoz) {
        int hossz = 0;
        boolean orient = true;
        return new Hajo(kezdoPoz, hossz, orient);
    }

    //Osztályok

    @Bean
    Jatek jatek(UIOutPutService uiOutPutService, UIInPutService uiInPutService, TablaService tablaService) {
        return new Jatek(uiOutPutService, uiInPutService, tablaService);
    }

    @Bean
    UjJatek ujJatek(UIInPutService uiInPutService, TablaService tablaService) {

        return new UjJatek(uiInPutService, tablaService);
    }


}
