package hu.nye.progtech.entity;


import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.model.Mezo;
import hu.nye.progtech.model.Pozicio;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "tabla")
public class Tabla {

    public Mezo[][] getJatekTer() {
        return jatekTer;
    }

    public int getSzelesseg() {
        return szelesseg;
    }

    public void setSzelesseg(int szelesseg) {
        this.szelesseg = szelesseg;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    private Mezo[][] jatekTer;

    public void setJatekTer(Mezo[][] jatekTer) {
        this.jatekTer = jatekTer;
    }

    private int szelesseg = 10;
    private int magassag = 10;

    public Tabla() {
    }

    public Tabla(Mezo[][] jatekTer) {
        this.jatekTer = jatekTer;
    }


    public Mezo getMezo(int i, int j) {
        return jatekTer[i][j];
    }


    public void setJatekTeMezo(int i, int j, boolean ertek) {
        jatekTer[i][j].setSzabad(ertek);
    }

    public List<Pozicio> getSzabadPozFor(int hajoHossza, boolean orient) {

        List<Pozicio> result = new ArrayList<>();
        int szabadHelyek;
        int x = 0;
        int y = 0;
        if (!orient) {
            x = hajoHossza - 1;
        }
        if (orient) {
            y = hajoHossza - 1;
        }

        for (int i = 0; i < 10 - x; i++) {
            for (int j = 0; j < 10 - y; j++) {
                szabadHelyek = 0;
                if (jatekTer[i][j].isSzabad()) {
                    for (int k = 0; k < hajoHossza; k++) {
                        if ((orient) && (jatekTer[i][j + k].isSzabad())) {
                            szabadHelyek++;
                        }

                        if ((!orient) && (jatekTer[i + k][j].isSzabad())) {
                            szabadHelyek++;
                        }
                    }
                }
                if (szabadHelyek == hajoHossza) {
                    result.add(new Pozicio(i, j));

                }
            }
        }
        return result;
    }


    public void sorKiIratas(int i) {
        System.out.printf("%2d", i + 1);
        for (int j = 0; j < 10; j++) {
            System.out.print(jatekTer[i][j].toString());
        }

    }
}