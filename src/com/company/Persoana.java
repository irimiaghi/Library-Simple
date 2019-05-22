package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persoana implements Serializable {
    private static final long serialVersionUID = 9176873029745254542L;
    private String username;
    private transient String parola;
    private int numarCartiImprumutate;

    public List<String> getListaCartiPerUser() {
        return listaCartiPerUser;
    }

    public void setListaCartiPerUser(List<String> listaCartiPerUser) {
        this.listaCartiPerUser = listaCartiPerUser;
    }

    private List<String> listaCartiPerUser = new ArrayList<String>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public int getNumarCartiImprumutate() {
        return numarCartiImprumutate;
    }

    public void setNumarCartiImprumutate(int numarCartiImprumutate) {
        this.numarCartiImprumutate = numarCartiImprumutate;
    }

    public Persoana(String username, String parola, int numarCartiImprumutate, List<String> listaCartiPerUser) {
        this.username = username;
        this.parola = parola;
        this.numarCartiImprumutate = numarCartiImprumutate;
        this.listaCartiPerUser = listaCartiPerUser;
    }

    public Persoana(String username, String parola, int numarCartiImprumutate) {
        this.username = username;
        this.parola = parola;
        this.numarCartiImprumutate = numarCartiImprumutate;
        this.listaCartiPerUser = new ArrayList<String>();
    }

    public void addCarte(String carte) {
        listaCartiPerUser.add(carte);
    }

    public void removeCarte(String carte) {
        listaCartiPerUser.remove(carte);
    }
}