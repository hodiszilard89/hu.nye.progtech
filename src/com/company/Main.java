package com.company;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    static private Tabla jatekosTabla = new Tabla(10,10);
    static private Tabla aiTabla = new Tabla(10,10);
    static private Tabla sajatLoves= new Tabla(10,10);
    static List<Hajo> hajok = new ArrayList<>();
    static final int x = 10;
    static final int y = 10;
    static private Random random = new Random();


    public static void main(String[] args)  {
        int x1=0,y1=0;
        jatekosTabla =new JatekVezerlo().getTabla();
        aiTabla = new JatekVezerlo().getTabla();
        tablaKirajzolas();
        for (int k=0; k<100; k++){
            x1=random.nextInt(10);
            y1=random.nextInt(10);
            if (!aiTabla.getMezo(x1,y1).isSzabad()){
                sajatLoves.getMezo(x1,y1).setTalalt();
                }
                else {
                sajatLoves.getMezo(x1,y1).setMelle();
                }
        }
        System.out.printf("\n\n");
        tablaKirajzolas();
        System.out.printf("\n\n");
        for(int i=0; i<10; i++){
            aiTabla.sorKiIratas(i);
            System.out.println();
        }
    }

        static void tablaKirajzolas(){

            System.out.println("         SAJÁT MEZŐD                                    LÖVÉSEID");
            for(int i=0; i<10; i++){
                jatekosTabla.sorKiIratas(i);
                System.out.print("               ");
                sajatLoves.sorKiIratas(i);
                System.out.println();
            }

        }

}


