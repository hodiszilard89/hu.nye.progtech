package service;

import model.Stat;
import model.Tabla;

import java.io.IOException;

public class UjJatek {
    static final int x = 10;
    static final int y = 10;

    //szervizek
    private UIService us ;
    private UserInput ui = new UserInput();
    private TablaService ts = new TablaService();

    //tablak
    private Tabla jatekosTabla = new Tabla(x, y);
    private Tabla aiTabla = new Tabla(x, y);
    private Tabla sajatLoves = new Tabla(10, 10);
    private Stat stat;




    public UjJatek() {
        stat = new Stat(ui.nevBekeres(System.in));
        jatekosTabla= ts.getRandomJatekTer();
        aiTabla=ts.getRandomJatekTer();
        new Jatek(jatekosTabla,aiTabla,sajatLoves,stat);

    }





    //szetterek
    public void setUs(UIService us) {
        this.us = us;
    }

    public void setUi(UserInput ui) {
        this.ui = ui;
    }

    public void setTs(TablaService ts) {
        this.ts = ts;
    }







}
