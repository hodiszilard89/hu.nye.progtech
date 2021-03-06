package hu.nye.progtech.service;

import java.sql.Connection;
import java.util.Random;

import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.model.Pozicio;
import hu.nye.progtech.model.Stat;
import hu.nye.progtech.repository.GameSaveWithJDBC;
import hu.nye.progtech.repository.GameSaveWithXml;



public class Jatek {

    private static UIOutPutService us = new UIOutPutService();
    private static UIInPutService ui = new UIInPutService();
    private static TablaService ts = new TablaService();
    private static GameSaveWithJDBC gspJ;
    private static GameSaveWithXml gspX;
    Connection con;
    private static Tabla jatekosTabla;
    private static Tabla aiTabla;
    private static Tabla sajatLoves;
    private static Stat stat;

    public Jatek(UIOutPutService uiOutPutService, UIInPutService uiInPutService, TablaService tablaService) {
        us = uiOutPutService;
        ui = uiInPutService;
        ts = tablaService;


    }

    public Jatek(Tabla jatekosTabla, Tabla aiTabla, Tabla sajatLoves, Stat stat) {
        this.jatekosTabla = jatekosTabla;
        this.aiTabla = aiTabla;
        this.sajatLoves = sajatLoves;
        this.stat = stat;
        this.gspX = new GameSaveWithXml();
        /*
        try{
            con= DriverManager.getConnection("jdbc:h2:tcp://localhost/./test", "sa", "admin");}
        catch (SQLException e){
            e.printStackTrace();
        }
        gsp=new GameSaveWithJDBC(con);
        */
        inditas();
    }

    private static void inditas() {

        Random random = new Random();
        Pozicio loves;
        boolean jatekosTalal;
        boolean gepTalal;
        int x1 = 0;
        int y1 = 0;

        us.tablaKirajzolas(jatekosTabla, sajatLoves);
        loves = ui.koordinataBe();

        if (loves == null) {
            mentes();
        } else {
            while (loves != null) {


                if (!aiTabla.getMezo(loves.getXkordinat(), loves.getYkordinat()).isSzabad()) {
                    sajatLoves.getMezo(loves.getXkordinat(), loves.getYkordinat()).setTalalt();
                    jatekosTalal = true;
                } else {
                    sajatLoves.getMezo(loves.getXkordinat(), loves.getYkordinat()).setLovesHelye(true);
                    jatekosTalal = false;
                }
                x1 = random.nextInt(10);
                y1 = random.nextInt(10);
                if (!jatekosTabla.getMezo(x1, y1).isSzabad()) {
                    jatekosTabla.getMezo(x1, y1).setTalalt();
                    gepTalal = true;
                } else {
                    jatekosTabla.getMezo(x1, y1).setLovesHelye(true);
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
        if (ui.userValasz("Befejezed a j??t??kot", System.in)) {
            gspX.save(jatekosTabla, "jatekosTabla.xml");
            gspX.save(aiTabla, "aiTabla.xml");
            gspX.save(sajatLoves, "sajatloves.xml");
            gspX.saveStat(stat, "statisztika.xml");
            /*
             gspJ.delete();
             gspJ.save(jatekosTabla,sajatLoves,aiTabla);
             */
            System.out.println("J??t??k elmentve");
        }

    }

}
