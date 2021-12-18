package service;

import model.Hajo;
import model.Pozicio;
import model.Tabla;
import interfaceek.MainServiceInterface;

import java.util.*;

public class TablaService implements MainServiceInterface {
    private final Random random = new Random();
    boolean orient;

    public TablaService() {}

    public void hajoLerakas(Tabla tabla, Pozicio poz, int hossz, boolean orient) {
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
            tabla.setJatekTeMezo(pozicio.getX(), pozicio.getY(), false);
        }
    }


    public Tabla getRandomJatekTer(){
        List<Pozicio> szabadHajoHelyek ;
        List<Hajo>  hajok=new ArrayList<>();
        Tabla jatekTer=new Tabla(10,10);
        int h ;
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
        Tabla result = new Tabla(10, 10);
        for (Hajo hajo : hajok) {
            for (int j = 0; j < hajo.getHajoElemek().size(); j++) {
                x = hajo.getHajoElemek().get(j).getX();
                y = hajo.getHajoElemek().get(j).getY();
                result.setJatekTeMezo(x, y, false);
            }
        }
        return result;
    }
    public boolean intToBool(int i) {
        return i == 1;
    }
}
