package hu.nye.progtech.model;


import java.util.Objects;

public class Mezo {
    public boolean isTalalat() {
        return talalat;
    }

    public void setTalalat(boolean talalat) {
        this.talalat = talalat;
    }

    public boolean isLovesHelye() {
        return lovesHelye;
    }

    public void setLovesHelye(boolean lovesHelye) {
        this.lovesHelye = lovesHelye;
    }

    private Pozicio pozicio;
    private boolean szabad;
    private boolean talalat;
    private boolean lovesHelye;

    public Mezo() {
    }

    public Pozicio getPozicio() {
        return pozicio;
    }

    public void setPozicio(Pozicio pozicio) {
        this.pozicio = pozicio;
    }

    public Mezo(Pozicio pozicio, boolean szabad) {
        this.pozicio = pozicio;
        this.szabad = szabad;
        this.talalat = false;
        this.lovesHelye = false;
    }

    public void setTalalt() {
        this.talalat = true;
    }

    public boolean getTalalat() {
        return this.talalat;
    }

    public boolean isSzabad() {
        return szabad;
    }

    public void setSzabad(boolean szabad) {
        this.szabad = szabad;
    }


    public String toString() {

        String result = "";

        if (lovesHelye) {
            return "\u001B[31m[X]";
        } else
        if (getTalalat()) {
            return "\u001B[32m[0]";
        } else
        if (isSzabad()) {
            return "\u001B[34m[ ]";
        } else
        if (!isSzabad()) {
            return "\u001B[33m[#]";
        }


        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mezo mezo = (Mezo) o;
        return szabad == mezo.szabad && Objects.equals(pozicio, mezo.pozicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pozicio, szabad);
    }
}
