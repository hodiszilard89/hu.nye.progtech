package hu.nye.progtech.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.interfaceek.MainServiceInterface;
import hu.nye.progtech.model.Hajo;
import hu.nye.progtech.model.Mezo;
import hu.nye.progtech.model.Pozicio;



public class TablaService implements MainServiceInterface {
    private final Random random = new Random();
    boolean orient;

    public TablaService() {
    }

    public Mezo[][] getNewTabla() {
        Mezo[][] result = new Mezo[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = new Mezo(new Pozicio(i, j), true);
            }
        }
        return result;
    }

    public void hajoLerakas(Tabla tabla, Pozicio poz, int hossz, boolean orient) {
        Set<Pozicio> halmaz = new HashSet<>();
        int x = 0;
        int y = 0;
        if (!orient) {
            x = 1;
        }
        if (orient) {
            y = 1;
        }
        for (int h = 0; h < hossz; h++) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    halmaz.add(new Pozicio((poz.getXkordinat() + (h * x)) + i, (poz.getYkordinat() + (h * y)) + j));
                }
            }
        }
        halmaz.removeIf(pozicio -> ((pozicio.isNegativ()) || (pozicio.isOut())));
        for (Pozicio pozicio : halmaz) {
            tabla.setJatekTeMezo(pozicio.getXkordinat(), pozicio.getYkordinat(), false);
        }
    }


    public Tabla getRandomJatekTer() {
        List<Pozicio> szabadHajoHelyek;
        List<Hajo> hajok = new ArrayList<>();
        Tabla jatekTer = new Tabla(new TablaService().getNewTabla());
        int h;
        for (int j = 4; j > 0; j--) {
            h = j;
            while (h > 0) {

                orient = intToBool(random.nextInt(2));
                szabadHajoHelyek = jatekTer.getSzabadPozFor(h, orient);
                int kiValaszPozi = random.nextInt(szabadHajoHelyek.size());
                hajoLerakas(jatekTer, szabadHajoHelyek.get(kiValaszPozi), h, orient);
                hajok.add(new Hajo(szabadHajoHelyek.get(kiValaszPozi), h, orient));
                h--;
            }
        }
        int x = 0;
        int y = 0;
        Tabla result = new Tabla(new TablaService().getNewTabla());
        for (Hajo hajo : hajok) {
            for (int j = 0; j < hajo.getHajoElemek().size(); j++) {
                x = hajo.getHajoElemek().get(j).getXkordinat();
                y = hajo.getHajoElemek().get(j).getYkordinat();
                result.setJatekTeMezo(x, y, false);
            }
        }
        return result;
    }

    public boolean intToBool(int i) {
        return i == 1;
    }
}
