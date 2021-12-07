package com.company.controller;

import com.company.entity.Tabla;
import com.company.service.MainService;
import com.company.service.UjJatek;



public class MainController {
    private MainService ms = new MainService();


    private UjJatek ujJatek;
    static final int x = 10;
    static final int y = 10;


    static private Tabla jatekosTabla = new Tabla(x,y);
    static private Tabla aiTabla = new Tabla(x,y);


    public MainController() {

        ujJatek=new UjJatek(ms);

        jatekosTabla =ms.getTabla();
        aiTabla = ms.getTabla();
        ujJatek.setAiTabla(aiTabla);
        ujJatek.setJatekosTabla(jatekosTabla);
        ujJatek.jatekInditas();
    }


}
