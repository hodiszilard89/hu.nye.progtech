package hu.nye.progtech.service;

import hu.nye.progtech.repository.GameSaveRep;
import hu.nye.progtech.model.Pozicio;
import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;

import java.util.Random;

public class Jatek {

    private static UIOutPutService us = new UIOutPutService();
    private static UIInPutService ui = new UIInPutService();
    private static TablaService ts = new TablaService();


    private static  Tabla jatekosTabla;
    private static Tabla aiTabla ;
    private static Tabla sajatLoves;
    private static Stat stat;

    public Jatek(UIOutPutService uiOutPutService, UIInPutService uiInPutService, TablaService tablaService){
         us = uiOutPutService;
         ui = uiInPutService;
         ts = tablaService;
    }

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
            new GameSaveRep().save(jatekosTabla, "jatekosTabla.xml");
            new GameSaveRep().save(aiTabla, "aiTabla.xml");
            new GameSaveRep().save(sajatLoves, "sajatloves.xml");
            new GameSaveRep().saveStat(stat, "statisztika.xml");
            System.out.println("Játék elmentve");
        }

    }

}
