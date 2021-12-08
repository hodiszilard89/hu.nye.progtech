package service;



import domain.Pozicio;
import domain.Tabla;
import interfaceek.XmlGameSaveRep;

import java.io.IOException;
import java.util.Random;

public class UjJatek {

    private service.UIService us = new UIService();
    private UserInput ui = new UserInput();
    private MainService ms ;

    static final int x = 10;
    static final int y = 10;
    private Tabla jatekosTabla = new Tabla(x,y);
    private Tabla aiTabla = new Tabla(x,y);

    public void setSajatLoves(Tabla sajatLoves) {
        this.sajatLoves = sajatLoves;
    }

    private Tabla sajatLoves= new Tabla(10,10);
    private Tabla jatekTer;
    private Random random = new Random();

    private Pozicio loves;

    private boolean jatekosTalal;
    private boolean gepTalal;


    public UjJatek(MainService ms) {
        this.ms=ms;
    }

  public void jatekInditas() throws IOException {
        int x1=0,y1=0;

        //direkt hiba a tesztelés miatt
        us.tablaKirajzolas(jatekosTabla,aiTabla);
        loves=ui.koordinataBe();
        if (loves==null) {
          System.out.println("Kilépés előtt elmented?");
          if (ui.kiLepesValasz() == 'y') {
              new XmlGameSaveRep().save(jatekosTabla, "jatekosTabla.xml");
              new XmlGameSaveRep().save(aiTabla, "aiTabla.xml");
          }

        }
        while( loves!=null ){


            if (!aiTabla.getMezo(loves.getX(), loves.getY()).isSzabad()){
                sajatLoves.getMezo(loves.getX(), loves.getY()).setTalalt();
                jatekosTalal=true;
            }
            else{
                sajatLoves.getMezo(loves.getX(), loves.getY()).setLovesHelye();
                jatekosTalal = false;
            }
            x1=random.nextInt(10);
            y1= random.nextInt(10);
            if (!jatekosTabla.getMezo(x1,y1).isSzabad()){
                jatekosTabla.getMezo(x1,y1).setTalalt();
                gepTalal=true;
            }else{
                jatekosTabla.getMezo(x1,y1).setLovesHelye();
                gepTalal=false;
            }
            us.tablaKirajzolas(jatekosTabla,sajatLoves);

            System.out.print(us.gepTalalat(gepTalal));
            System.out.println(us.jatekosTalalat(jatekosTalal));

            loves=ui.koordinataBe();
            System.out.println(loves);
            if (loves==null) {
                System.out.println("Kilépés előtt elmented?");
                if (ui.kiLepesValasz() == 'y') {
                    new XmlGameSaveRep().save(jatekosTabla, "jatekosTabla.xml");
                    new XmlGameSaveRep().save(aiTabla, "aiTabla.xml");
                    new XmlGameSaveRep().save(sajatLoves,"sajatloves.xml");
                    }

            }

        }
    }


    public void setJatekosTabla(Tabla jatekosTabla) {
        this.jatekosTabla = jatekosTabla;
    }

    public void setAiTabla(Tabla aiTabla) {
        this.aiTabla = aiTabla;
    }
}
