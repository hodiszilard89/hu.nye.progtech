package com.company;


import java.util.Objects;

public class Mezo {
    private Pozicio pozicio;
    private boolean szabad;
    private boolean talalat;
    private boolean lovesHelye;

    public Mezo(Pozicio pozicio, boolean szabad) {
        this.pozicio = pozicio;
        this.szabad = szabad;
        this.talalat = false;
        this.lovesHelye = false;
    }

    public void setLovesHelye() {
        this.lovesHelye =true;
    }

    /*public void setMelle(){
            this.lovesHelye=true;
        }*/
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


    @Override
    public String toString() {
        String result = "";

        if (lovesHelye) {
            return "\u001B[31m[X]";
        }
        if (getTalalat()) {
            return "\u001B[32m[0]";
        }
        if (isSzabad()) {
            return "\u001B[34m[ ]";
        }
        if (!isSzabad()) {
            return "\u001B[33m[#]";
        }


        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mezo mezo = (Mezo) o;
        return szabad == mezo.szabad && Objects.equals(pozicio, mezo.pozicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pozicio, szabad);
    }
}
