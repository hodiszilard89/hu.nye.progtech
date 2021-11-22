package com.company;

import java.util.*;

public class JatekVezerlo {

    private List<Hajo> hajok = new ArrayList<>();
    private List<Pozicio> szabadHajoHelyek;
    private Random random = new Random();
    boolean orient;
    private Tabla jatekTer;
    private int kiValaszPozi;

    public JatekVezerlo() {
        jatekTer = new Tabla(10, 10);
        int i = 0;
        for (int j = 4; j > 0; j--) {
            i = j;
            while (i > 0) {

                orient = intToBool(random.nextInt(2));

                szabadHajoHelyek = jatekTer.getSzabadPozFor(i, orient);

                kiValaszPozi = random.nextInt(szabadHajoHelyek.size());
                hajoLerakás(szabadHajoHelyek.get(kiValaszPozi), i, orient);
                hajok.add(new Hajo(szabadHajoHelyek.get(kiValaszPozi), i, orient));
                i--;
            }
        }
        tablakirajzolas();
    }

    public void hajoLerakás(Pozicio poz, int hossz, boolean orient) {
        Set<Pozicio> halmaz = new HashSet<>();
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

    public List<Hajo> getHajok(){
        return hajok;
    }

    public void tablakirajzolas() {
        int x = 0;
        int y = 0;
        Tabla jatekter2 = new Tabla(10, 10);
        for (int i = 0; i < hajok.size(); i++) {
            for (int j = 0; j < hajok.get(i).getHajoElemek().size(); j++) {
                x = hajok.get(i).getHajoElemek().get(j).getX();
                y = hajok.get(i).getHajoElemek().get(j).getY();
                jatekter2.setJatekTeMezo(x, y, false);
            }
        }
        jatekter2.kiiratas();

    }

    static boolean intToBool(int i) {
        boolean result = false;
        if (i == 1) result = true;
        return result;
    }
}
