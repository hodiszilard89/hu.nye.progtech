package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

import hu.nye.progtech.interfaceek.HajoInterface;

public class Hajo implements HajoInterface {

    private List<Pozicio> hajoElemek;
    private Pozicio kezdoPoz;
    private int hossz;
    private boolean orient;

    public Hajo(Pozicio kezdoPoz, int hossz, boolean orient) {
        this.kezdoPoz = kezdoPoz;
        this.hossz = hossz;
        this.orient = orient;
    }

    public List<Pozicio> getHajoElemek() {
        int x = 0;
        int y = 0;
        if (!orient) {
            x = 1;
        }
        if (orient) {
            y = 1;
        }
        List<Pozicio> hajoElemek = new ArrayList<>();
        for (int h = 0; h < hossz; h++) {
            hajoElemek.add(new Pozicio(this.kezdoPoz.getXkordinat() + (x * h), this.kezdoPoz.getYkordinat() + (y * h)));
        }

        return hajoElemek;
    }

    @Override
    public String toString() {
        return "x:y " + this.hajoElemek.get(0).getXkordinat() + ":" + this.hajoElemek.get(0).getYkordinat() + " hossza:" +
                this.hajoElemek.size();
    }
}