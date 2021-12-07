package com.company.service;

import com.company.entity.Pozicio;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    static private final String kOODTINATA_REG = "^[a-jA-J]+\\:+(([0-9])||10)";
    public UserInput(){};
    public Pozicio koordinataBe() {
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
            if (kordinata.equals("exit")){
                return null;
            }
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
}
