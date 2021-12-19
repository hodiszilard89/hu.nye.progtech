package hu.nye.progtech.model;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "jatekos")
public class Stat {

    private String jatekosNeve;
    private int gyozelem;
    private int osszJatek;
    private int vereseg;
    private int felbehagyott;

    public Stat(String jatekosNeve) {
        this.jatekosNeve = jatekosNeve;
    }

    public String getJatekosNeve() {
        return jatekosNeve;
    }

    public void setJatekosNeve(String jatekosNeve) {
        this.jatekosNeve = jatekosNeve;
    }

    public int getGyozelem() {
        return gyozelem;
    }

    public void setGyozelem(int gyozelem) {
        this.gyozelem = gyozelem;
    }

    public int getOsszJatek() {
        return osszJatek;
    }

    public void setOsszJatek(int osszjatek) {
        this.osszJatek = osszjatek;
    }

    public int getVereseg() {
        return vereseg;
    }

    public void setVereseg(int vereseg) {
        this.vereseg = vereseg;
    }

    public int getFelbehagyott() {
        return felbehagyott;
    }

    public void setFelbehagyott(int felbehagyott) {
        this.felbehagyott = felbehagyott;
    }

    Stat(){}

    @Override
    public String toString() {
        return "Stat:\n" +
                "JátekosNeve= " + jatekosNeve +"\n" +
                "   Gyozelem= " + gyozelem +"\n" +
                "  ÖsszJatek= " + osszJatek +"\n"+
                "    vereseg= " + vereseg +"\n" +
                "félbehagyott=" + felbehagyott ;
    }
}
