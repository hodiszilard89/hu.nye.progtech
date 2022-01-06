package hu.nye.progtech.controller;


import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.repository.GameSaveWithJDBC;
import hu.nye.progtech.repository.GameSaveWithXml;
import hu.nye.progtech.service.*;
import jakarta.xml.bind.JAXBException;


public class MainController {
    private TablaService ts ;
    private FileService fs;
    private GameSaveWithJDBC gspJ;
    private GameSaveWithXml gspX;

    static final String jatekosTablaFile="jatekostabla.xml";
    static final String aiTablaFile="aitabla.xml";
    static final String jatekoLovesekFile="sajatloves.xml";
    static final String jatekosStatFile="statisztika.xml";

    static final int x = 10;
    static final int y = 10;

    static private Tabla aiTabla ;
    static private Tabla sajatLoves ;
    static private Tabla jatekosTabla;
    static private Stat stat ;
    private UjJatek ujJatek;
    UIInPutService ui=new UIInPutService();

    public MainController(TablaService ts, FileService fs, UIInPutService ui, GameSaveWithXml gspX) {
        this.ts = ts;
        this.fs = fs;
        this.ui = ui;
        this.gspX=gspX;
    }

    public MainController(){};
    public void start(){
        boolean letezikMentettJatek=true;

        try {
            jatekosTabla = gspX.load(jatekosTablaFile);
            aiTabla = gspX.load(aiTablaFile);
            sajatLoves = gspX.load(jatekoLovesekFile);
            stat = gspX.loadStat(jatekosStatFile);
//              jatekosTabla=gspJ.loadTabla("jatekostabla");
//              aiTabla=gspJ.loadTabla("aitabla");
//              sajatLoves=gspJ.loadTabla("sajatloves");

            }
         catch (IllegalArgumentException | NullPointerException | JAXBException e) {

             letezikMentettJatek = false;
        }

        if ((letezikMentettJatek)&&(sajatLoves!=null)){
            if( !ui.userValasz("Folytatod az előző játékot? ", System.in)){
                fs.delete(jatekosTablaFile);
                fs.delete(jatekoLovesekFile);
                fs.delete(jatekosStatFile);
                fs.delete(aiTablaFile);
                new UjJatek();
                }
                else{
                    System.out.println("Üdvözöllek: "+ stat.getJatekosNeve());
                    new UjJatek(jatekosTabla,aiTabla,sajatLoves,stat);
                }
            }
        else{
            new UjJatek();
        }

    }


}
