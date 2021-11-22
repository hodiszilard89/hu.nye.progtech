package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Tabla {

    private Mezo[][] jatekTer;
    private int x, y;

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

    public Set foglaltMezok(){
        Set<Pozicio> result = new HashSet<>();
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if (!jatekTer[i][j].isSzabad()){
                    for(int k=-1; k<2; k++){
                        for(int l=-1; l<2; l++){
                            result.add(new Pozicio(i+k,j+l));
                        }
                    }
                }
            }
        }
        result.removeIf(pozicio -> ((pozicio.isNegativ())||(pozicio.isOut())));

        return result;
    }

    public void kiiratas() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (jatekTer[i][j].isSzabad())
                    System.out.print("\u001B[34m[ ]");
                if(!jatekTer[i][j].isSzabad())
                    System.out.print("\u001B[33m[#]");
            }
            System.out.println();
        }
    }
}