package com.company;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {

    static List<Hajo> hajok = new ArrayList<>();
    static Hajo hajo1;
    static final int x = 10;

    static final int y = 10;
    static String[][] tabla = new String[x][y];
    static Random random = new Random();

    public static void main(String[] args)  {
        new JatekVezerlo();


     /*  Tabla jatekTer= new Tabla(10,10);
       List<Pozicio> szabadPozicok;
       int randomPozi;
       hajoLerakás(new Pozicio(3,0),4,1);
       //jatekTer.hajoLerakás(new Pozicio(4,3),4,1);
       jatekTer.kiiratas();
*/
    }


   /*static  public Hajo hajoKeszites(int hossz) {

        List<Pozicio> hajoElemek = new ArrayList<>();

        int x1 = 0, y1 = 0;
        int orientacio = 0;
        orientacio = random.nextInt(2);

        if (orientacio == 0) {
            x1 = random.nextInt(x);
            if (0 < (y - hossz)) y1 = random.nextInt(y - hossz);
            else {
                y1 = 0;
            }
        }


        if (orientacio == 1) {
            y1 = random.nextInt(y);
            if (0 < (x - hossz)) x1 = random.nextInt(x - hossz);
            else {
                x1 = 0;
            }
        }

        if (orientacio == 0) {
            for (int i = 0; i < hossz; i++) {
                hajoElemek.add(new Pozicio(x1, y1 + i));
            }
        }

        if (orientacio == 1) {
            for (int i = 0; i < hossz; i++) {
                hajoElemek.add(new Pozicio(x1 + i, y1));
            }
        }

        return  new Hajo();
    }*/
}

