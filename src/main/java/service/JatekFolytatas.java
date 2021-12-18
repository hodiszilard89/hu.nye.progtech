package service;


import interfaceek.XmlGameSaveRep;
import model.Stat;
import model.Tabla;

public class JatekFolytatas {

    private service.UIService us = new UIService();
    private UserInput ui = new UserInput();
    private TablaService ms;


    private Stat stat;

    static final int x = 10;
    static final int y = 10;
    private Tabla jatekosTabla = new Tabla(x, y);
    private Tabla aiTabla = new Tabla(x, y);


    private Tabla sajatLoves = new Tabla(10, 10);
    //private Tabla jatekTer;



    public JatekFolytatas(TablaService ms) {
        this.ms = ms;
    }



    public void setJatekosTabla(Tabla jatekosTabla) {
        this.jatekosTabla = jatekosTabla;
    }

    public void setAiTabla(Tabla aiTabla) {
        this.aiTabla = aiTabla;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public void setSajatLoves(Tabla sajatLoves) {
        this.sajatLoves = sajatLoves;
    }

    void mentes() {
        if (ui.userValasz("Befejezed a játékot",System.in)) {
            new XmlGameSaveRep().save(jatekosTabla, "jatekosTabla.xml");
            new XmlGameSaveRep().save(aiTabla, "aiTabla.xml");
            new XmlGameSaveRep().save(sajatLoves, "sajatloves.xml");
            new XmlGameSaveRep().saveStat(stat, "statisztika.xml");
        }

    }
}
