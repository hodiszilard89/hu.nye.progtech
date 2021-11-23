package com.company;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static private final String kOODTINATA_REG = "^[a-jA-J]+\\:+(([0-9])||10)";
    static private Tabla jatekosTabla = new Tabla(10,10);
    static private Tabla aiTabla = new Tabla(10,10);
    static private Tabla sajatLoves= new Tabla(10,10);
    static List<Hajo> hajok = new ArrayList<>();
    static final int x = 10;
    static final int y = 10;
    static private Random random = new Random();
    static private Pozicio loves;

    public static void main(String[] args){

        int x1=0,y1=0;
        Pozicio aiLoves;
        jatekosTabla =new JatekVezerlo().getTabla();
        aiTabla = new JatekVezerlo().getTabla();
        while(true){
            tablaKirajzolas();
            loves=koordinataBe();
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
        }

    }
        static Pozicio koordinataBe() {
            Pozicio result = null;
            int x=0;
            int y=0;
            Scanner sc=new Scanner(System.in);
            boolean kilep=false;
            String kordinata;
            Matcher mt;
            Pattern pt = Pattern.compile(kOODTINATA_REG);

            while (!kilep) {
                System.out.print("Kérem a koordinátát (pl.: a-j:1-10):");
                kordinata = sc.nextLine();
                mt = pt.matcher(kordinata);
                if (mt.matches()) {
                    kordinata=kordinata.toUpperCase();
                    y= (int) kordinata.charAt(0)-65;
                    x=Integer.parseInt(kordinata.substring(2))-1;
                    result = new Pozicio(x,y);

                    kilep=true;
                } else {
                    System.out.println("Nem megfelelő formátum.");
                }
            }
            return result;
        }

        static void tablaKirajzolas(){

            System.out.println("         SAJÁT MEZŐD                                         LÖVÉSEID");
            System.out.println("   A  B  C  D  E  F  G  H  I  J                   A  B  C  D  E  F  G  H  I  J");
            for(int i=0; i<10; i++){
                jatekosTabla.sorKiIratas(i);
                System.out.print("               ");
                sajatLoves.sorKiIratas(i);
                System.out.println();
            }

        }

}


