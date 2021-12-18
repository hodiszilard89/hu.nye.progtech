package service;

import interfaceek.XmlGameSaveRep;
import model.Pozicio;
import model.Stat;
import model.Tabla;

import java.io.IOException;
import java.util.Random;

public class Jatek {

    private static service.UIService us = new UIService();
    private static UserInput ui = new UserInput();
    private static TablaService ms= new TablaService();


    private static  Tabla jatekosTabla;
    private static Tabla aiTabla ;
    private static Tabla sajatLoves;
    private static Stat stat;


    public Jatek(Tabla jatekosTabla, Tabla aiTabla, Tabla sajatLoves, Stat stat) {
        this.jatekosTabla = jatekosTabla;
        this.aiTabla = aiTabla;
        this.sajatLoves = sajatLoves;
        this.stat = stat;
        inditas();
    }
    private static void inditas( )  {

        Random random = new Random();
        Pozicio loves;
        boolean jatekosTalal;
        boolean gepTalal;
        int x1,y1;

        us.tablaKirajzolas(jatekosTabla, sajatLoves);
        loves = ui.koordinataBe();

        if (loves == null) {
            mentes();
        } else {
            while (loves != null) {


                if (!aiTabla.getMezo(loves.getX(), loves.getY()).isSzabad()) {
                    sajatLoves.getMezo(loves.getX(), loves.getY()).setTalalt();
                    jatekosTalal = true;
                } else {
                    sajatLoves.getMezo(loves.getX(), loves.getY()).setLovesHelye();
                    jatekosTalal = false;
                }
                x1 = random.nextInt(10);
                y1 = random.nextInt(10);
                if (!jatekosTabla.getMezo(x1, y1).isSzabad()) {
                    jatekosTabla.getMezo(x1, y1).setTalalt();
                    gepTalal = true;
                } else {
                    jatekosTabla.getMezo(x1, y1).setLovesHelye();
                    gepTalal = false;
                }
                us.tablaKirajzolas(jatekosTabla, sajatLoves);

                System.out.print(us.gepTalalat(gepTalal));
                System.out.println(us.jatekosTalalat(jatekosTalal));

                loves = ui.koordinataBe();
                if (loves == null) {
                    mentes();

                }

            }
        }
    }
    static void mentes() {
        if (ui.userValasz("Befejezed a játékot",System.in)) {
            new XmlGameSaveRep().save(jatekosTabla, "jatekosTabla.xml");
            new XmlGameSaveRep().save(aiTabla, "aiTabla.xml");
            new XmlGameSaveRep().save(sajatLoves, "sajatloves.xml");
            new XmlGameSaveRep().saveStat(stat, "statisztika.xml");
        }

    }

}
