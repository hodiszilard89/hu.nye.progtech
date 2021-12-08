package domain;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "tabla")
public class Tabla {

    private Mezo[][] jatekTer;

    public Mezo[][] getJatekTer() {
        return jatekTer;
    }

    public void setJatekTer(Mezo[][] jatekTer) {
        this.jatekTer = jatekTer;
    }

    private int x, y;
    public Tabla(){}
    public Tabla(int x, int y) {
        this.x = 10;
        this.y = 10;
        jatekTer = new Mezo[x][y];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                jatekTer[i][j] = new Mezo(new Pozicio(i, j), true);
            }
        }
    }

    public Mezo getMezo(int i, int j){
        return jatekTer[i][j];
    }


    public void setJatekTeMezo(int i, int j, boolean ertek){
        jatekTer[i][j].setSzabad(ertek);
    }

    public List<Pozicio> getSzabadPozFor(int hajoHossza, boolean orient) {

        List<Pozicio> result = new ArrayList<>();
        int szabadHelyek;
        int x = 0, y = 0;
        if (!orient) x = hajoHossza-1;
        if (orient) y = hajoHossza-1;

        for (int i = 0; i < 10 - x; i++) {
            for (int j = 0; j < 10 - y; j++) {
                szabadHelyek = 0;
                if (jatekTer[i][j].isSzabad()) {
                    for (int k = 0; k < hajoHossza; k++) {
                        if ((orient) && (jatekTer[i][j + k].isSzabad()))
                            szabadHelyek++;

                        if ((!orient) && (jatekTer[i + k][j].isSzabad()))
                            szabadHelyek++;
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
            System.out.printf("%2d",i+1);
            for (int j = 0; j < 10; j++) {
                System.out.print(jatekTer[i][j].toString());
            }

    }
}