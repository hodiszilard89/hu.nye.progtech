package hu.nye.progtech.controller;


import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;
import hu.nye.progtech.repository.GameSaveRep;
import jakarta.xml.bind.JAXBException;
import hu.nye.progtech.service.*;




public class MainController {
    private TablaService ts ;
    private FileService fs;
    private GameSaveRep gsp;
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

    public MainController(TablaService ts, FileService fs, UIInPutService ui, GameSaveRep gsp) {
        this.ts = ts;
        this.fs = fs;
        this.ui = ui;
        this.gsp=gsp;
    }

    public MainController(){};
    public void start(){
        boolean letezikMentettJatek=true;

        try {
            jatekosTabla = gsp.load(jatekosTablaFile);
            aiTabla = gsp.load(aiTablaFile);
            sajatLoves = gsp.load(jatekoLovesekFile);
            stat = gsp.loadStat(jatekosStatFile);

            }
         catch (IllegalArgumentException | NullPointerException | JAXBException e) {

             letezikMentettJatek = false;
         }

        if (letezikMentettJatek){
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
