package service;


import domain.Tabla;

public class UIService {
    public UIService() {}

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

    public String gepTalalat(boolean b){
        if (b) {return "            GÉP  TALÁLAT                                 ";}

       return "            GÉP MELLÉ                                   ";
    }

    public String jatekosTalalat(boolean b){

        if (b) {return "JÁTÉKOS  TALÁLAT";}

        return "JÁTÉKOS MELLÉ";
    }

}
