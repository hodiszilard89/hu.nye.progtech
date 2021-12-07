package com.company.controller;

import com.company.entity.Tabla;
import com.company.entity.Hajo;
import com.company.entity.Pozicio;
import com.company.service.UI;
import com.company.service.UserInput;

import java.util.*;

public class JatekController {

    static private Tabla sajatLoves= new Tabla(10,10);
    static final int x = 10;
    static final int y = 10;
    private List<Pozicio> szabadHajoHelyek;

    static private Tabla jatekosTabla = new Tabla(10,10);
    static private Tabla aiTabla = new Tabla(10,10);
    private List<Hajo> hajok;
    private UI ui = new UI();
    private Random random = new Random();
    boolean orient;
    private Tabla jatekTer;
    private int kiValaszPozi;
    private UserInput in=new UserInput();
    static private Pozicio loves;


    public JatekController() {
        jatekTer = new Tabla(10, 10);
        jatekInditas();
    }

    private void jatekInditas(){

        int x1=0,y1=0;
        jatekosTabla =getTabla();
        aiTabla = getTabla();
        loves=in.koordinataBe();
        while( loves!=null ){


            if (!aiTabla.getMezo(loves.getX(), loves.getY()).isSzabad()){
                System.out.println("Játékos: TALÁLAT");
                sajatLoves.getMezo(loves.getX(), loves.getY()).setTalalt();
            }
            else{
                System.out.println("Játékos: MELLÉ");
                sajatLoves.getMezo(loves.getX(), loves.getY()).setLovesHelye();
            }
            x1=random.nextInt(10);
            y1= random.nextInt(10);
            if (!jatekosTabla.getMezo(x1,y1).isSzabad()){
                jatekosTabla.getMezo(x1,y1).setTalalt();
                System.out.println("Gép TALÁLAT");
            }else{
                jatekosTabla.getMezo(x1,y1).setLovesHelye();
                System.out.println("Gép MELLÉ");
            }
            ui.tablaKirajzolas(jatekosTabla,sajatLoves);
            loves=in.koordinataBe();
        }
    }



    public void hajoLerakas(Pozicio poz, int hossz, boolean orient) {
        Set<Pozicio> halmaz = new HashSet<>();
        System.out.println("leraktam egy hajót");
        int x = 0;
        int y = 0;
        if (!orient) x = 1;
        if (orient) y = 1;
        for (int h = 0; h < hossz; h++) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    halmaz.add(new Pozicio((poz.getX() + (h * x)) + i, (poz.getY() + (h * y)) + j));
                }
            }
        }
        halmaz.removeIf(pozicio -> ((pozicio.isNegativ()) || (pozicio.isOut())));
        for (Pozicio pozicio : halmaz) {
            jatekTer.setJatekTeMezo(pozicio.getX(), pozicio.getY(), false);
        }

    }

    public Tabla getTabla(){
        szabadHajoHelyek=new ArrayList<>();
        hajok=new ArrayList<>();
        jatekTer=new Tabla(10,10);
        int h ;
        for (int j = 4; j > 0; j--) {
            h = j;
            while (h > 0) {

                orient = intToBool(random.nextInt(2));
                szabadHajoHelyek = jatekTer.getSzabadPozFor(h, orient);
                kiValaszPozi = random.nextInt(szabadHajoHelyek.size());
                hajoLerakas(szabadHajoHelyek.get(kiValaszPozi), h, orient);
                hajok.add(new Hajo(szabadHajoHelyek.get(kiValaszPozi), h, orient));
                h--;
            }
        }
        int x = 0;
        int y = 0;
        Tabla result = new Tabla(10, 10);
        for (int i = 0; i < hajok.size(); i++) {
            for (int j = 0; j < hajok.get(i).getHajoElemek().size(); j++) {
                x = hajok.get(i).getHajoElemek().get(j).getX();
                y = hajok.get(i).getHajoElemek().get(j).getY();
                result.setJatekTeMezo(x, y, false);
            }
        }
        return result;
    }

    static boolean intToBool(int i) {
        boolean result = false;
        if (i == 1) result = true;
        return result;
    }
}
