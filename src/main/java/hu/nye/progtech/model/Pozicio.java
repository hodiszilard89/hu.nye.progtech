package hu.nye.progtech.model;

import java.util.Objects;

public class Pozicio {
    private int xkordinat;
    private int ykordinat;

    public void setXkordinat(int xkordinat) {
        this.xkordinat = xkordinat;
    }

    public void setYkordinat(int ykordinat) {
        this.ykordinat = ykordinat;
    }

    public Pozicio() {
    }

    public Pozicio(int x, int y) {
        this.xkordinat = x;
        this.ykordinat = y;
    }

    public int getXkordinat() {
        return xkordinat;
    }

    public int getYkordinat() {
        return ykordinat;
    }

    @Override
    public String toString() {
        return "Pozicio{" +
                "x=" + xkordinat +
                ", y=" + ykordinat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pozicio pozicio = (Pozicio) o;
        return xkordinat == pozicio.xkordinat && ykordinat == pozicio.ykordinat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xkordinat, ykordinat);
    }

    public boolean isNegativ() {
        boolean result = false;
        if ((getXkordinat() < 0) || (getYkordinat() < 0)) {
            result = true;
        }
        return result;
    }

    public boolean isOut() {
        boolean result = false;
        if ((getXkordinat() > 9) || (getYkordinat() > 9)) {
            result = true;
        }
        return result;
    }

}
