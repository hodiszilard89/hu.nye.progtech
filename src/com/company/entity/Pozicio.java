package com.company.entity;

import java.util.Objects;

public class Pozicio {

    private int x;
    private int y;
    public Pozicio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pozicio{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozicio pozicio = (Pozicio) o;
        return x == pozicio.x && y == pozicio.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isNegativ(){
        boolean result= false;
        if ((getX()<0)||(getY()<0)) result=true;
        return result;
    }

    public boolean isOut(){
        boolean result= false;
        if ((getX()>9)||(getY()>9)) result=true;
        return result;
    }
}