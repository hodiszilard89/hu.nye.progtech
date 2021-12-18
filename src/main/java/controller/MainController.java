package controller;


import model.Stat;
import model.Tabla;
import interfaceek.XmlGameSaveRep;
import jakarta.xml.bind.JAXBException;
import service.*;




public class MainController {
    private final TablaService ms = new TablaService();

    static final String jatekosTablaFile="jatekostabla.xml";
    static final String aiTablaFile="aitabla.xml";
    static final String jatekoLovesekFile="sajatloves.xml";
    static final String jatekosStatFile="statisztika.xml";

    static final int x = 10;
    static final int y = 10;

    static private Tabla aiTabla = new Tabla(x,y);
    static private Tabla sajatLoves = new Tabla(x,y);
    static private Tabla jatekosTabla = new Tabla(x,y);
    static private Stat stat ;
    private final FileService fs= new FileService();
    UserInput ui=new UserInput();




    public MainController() throws JAXBException {
        boolean letezikMentettJatek=true;
        try {
            jatekosTabla = new XmlGameSaveRep().load(jatekosTablaFile);
            aiTabla = new XmlGameSaveRep().load(aiTablaFile);
            sajatLoves = new XmlGameSaveRep().load(jatekoLovesekFile);
            stat = new XmlGameSaveRep().loadStat(jatekosStatFile);
            }
         catch (IllegalArgumentException | NullPointerException e) {

            letezikMentettJatek=false;
        }

        if (letezikMentettJatek){
            if( !ui.userValasz("Folytatod az előző játékot? ", System.in)){
                fs.delete(jatekosTablaFile);
                fs.delete(jatekoLovesekFile);
                fs.delete(jatekosStatFile);
                fs.delete(aiTablaFile);
                init();
            }
        }
        else{
             init();
        }

        JatekFolytatas ujJatek = new JatekFolytatas(ms);
        ujJatek.setStat(stat);
        ujJatek.setAiTabla(aiTabla);
        ujJatek.setSajatLoves(sajatLoves);
        ujJatek.setJatekosTabla(jatekosTabla);
        new UjJatek();

    }
    private void init(){
        jatekosTabla=ms.getRandomJatekTer();
        aiTabla=ms.getRandomJatekTer();

    }

}
