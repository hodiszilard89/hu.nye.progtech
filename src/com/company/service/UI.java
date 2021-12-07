package com.company.service;

import com.company.entity.Hajo;
import com.company.entity.Tabla;

import java.util.List;

public class UI {
    public UI() {}
//    public void tablakirajzolas(List<Hajo> hajok) {
//        int x = 0;
//        int y = 0;
//        Tabla jatekter2 = new Tabla(10, 10);
//        for (Hajo hajo : hajok) {
//            for (int j = 0; j < hajo.getHajoElemek().size(); j++) {
//                x = hajo.getHajoElemek().get(j).getX();
//                y = hajo.getHajoElemek().get(j).getY();
//                jatekter2.setJatekTeMezo(x, y, false);
//            }
//        }
//    }

    public void tablaKirajzolas(Tabla tabla1, Tabla tabla2){

        System.out.println("         SAJÁT MEZŐD                                         LÖVÉSEID");
        System.out.println("   A  B  C  D  E  F  G  H  I  J                   A  B  C  D  E  F  G  H  I  J");
        for(int i=0; i<10; i++){
            tabla1.sorKiIratas(i);
            System.out.print("               ");
            tabla2.sorKiIratas(i);
            System.out.println();
        }

    }

}
