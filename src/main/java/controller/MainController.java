package controller;


import domain.Tabla;
import interfaceek.XmlGameSaveRep;
import jakarta.xml.bind.JAXBException;
import service.MainService;
import service.UjJatek;

import java.io.IOException;
import java.util.Scanner;


public class MainController {
    private MainService ms = new MainService();


    private UjJatek ujJatek;
    static final int x = 10;
    static final int y = 10;


    static private Tabla jatekosTabla = new Tabla(x,y);
    static private Tabla aiTabla = new Tabla(x,y);
    static private Tabla sajatLoves = new Tabla(x,y);

    public MainController() throws IOException, JAXBException {

        System.out.println("Játék folytatása?(y/n)");
        Scanner sc=new Scanner(System.in);
        char c = (char) System.in.read();
        System.in.read();
        if (c=='n') {
            jatekosTabla =ms.getTabla();
            aiTabla = ms.getTabla();
            }
            else{
            if (c=='y'){
                jatekosTabla =new XmlGameSaveRep().load("jatekostabla.xml");
                aiTabla = new XmlGameSaveRep().load("aitabla.xml");
                sajatLoves = new XmlGameSaveRep().load("sajatloves.xml");
            }
        }
        ujJatek = new UjJatek(ms);
        ujJatek.setAiTabla(aiTabla);
        ujJatek.setSajatLoves(sajatLoves);
        ujJatek.setJatekosTabla(jatekosTabla);
        ujJatek.jatekInditas();
    }


}
