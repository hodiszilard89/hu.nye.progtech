package com.company;

import java.sql.PreparedStatement;
import java.util.Objects;

public class Mezo {
    private Pozicio pozicio;
    private boolean szabad ;

    public Mezo(Pozicio pozicio, boolean szabad) {
        this.pozicio = pozicio;
        this.szabad = szabad;

    }

    public Pozicio getPozicio() {
        return pozicio;
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
        if (this.isSzabad()) {
            result = "\u001B[34m[ ]";
        } else {
            result = "\u001B[33m[#]";
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
