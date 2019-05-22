package com.company;

import java.io.Serializable;

public class Carti implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;
    private String numeCarte;
    private String tipCarte;

    @Override
    public String toString() {
        return "Nume carte= '" + numeCarte + '\'' + ", tipCarte='" + tipCarte + '\'' + ", resumat='" + resumat + '\'' + ", numar de carti= " + contorCartiPerCarte;
    }

    private String resumat;
    private int contorCartiPerCarte;

    Carti(String numeCarte, String tipCarte, String resumat, int contorCartiPerCarte) {
        this.numeCarte = numeCarte;
        this.tipCarte = tipCarte;
        this.resumat = resumat;
        this.contorCartiPerCarte = contorCartiPerCarte;
    }

    String getNumeCarte() {
        return numeCarte;
    }

    void setNumeCarte(String numeCarte) {
        this.numeCarte = numeCarte;
    }


    void setTipCarte(String tipCarte) {
        this.tipCarte = tipCarte;
    }

    int getContorCartiPerCarte() {
        return contorCartiPerCarte;
    }

    void setContorCartiPerCarte(int contorCartiPerCarte) {
        this.contorCartiPerCarte = contorCartiPerCarte;
    }

    void setResumat(String resumat) {
        this.resumat = resumat;
    }


}
