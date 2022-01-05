package hu.nye.progtech.service;

import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;

public class UjJatek {
    static final int x = 10;
    static final int y = 10;

    //szervizek

    private UIInPutService ui = new UIInPutService();
    private TablaService ts = new TablaService();

    //tablak
    private Tabla jatekosTabla;
    private Tabla aiTabla ;
    private Tabla sajatLoves ;
    private Stat stat;

    public UjJatek( UIInPutService uiInPutService, TablaService tablaService) {
        this.ui=uiInPutService;
        this.ts=tablaService;
    }


    public UjJatek() {
        stat = new Stat(ui.nevBekeres(System.in));
        jatekosTabla= ts.getRandomJatekTer();
        aiTabla=ts.getRandomJatekTer();
        sajatLoves = new Tabla(ts.getNewTabla());
        new UjJatek(jatekosTabla,aiTabla,sajatLoves,stat);

    }

    public UjJatek(Tabla jatekosTabla, Tabla aiTabla, Tabla sajatLoves, Stat stat) {
        this.jatekosTabla = jatekosTabla;
        this.aiTabla = aiTabla;
        this.sajatLoves = sajatLoves;
        this.stat = stat;
        new Jatek(jatekosTabla,aiTabla,sajatLoves,stat);
    }



    public void setUi(UIInPutService ui) {
        this.ui = ui;
    }

    public void setTs(TablaService ts) {
        this.ts = ts;
    }







}
