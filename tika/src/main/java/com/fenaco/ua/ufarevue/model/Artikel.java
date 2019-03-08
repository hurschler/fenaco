package com.fenaco.ua.ufarevue.model;

public class Artikel {
    private String thema;
    private String titel;
    private String untertitel;
    private Autor autor;
    private Ausgabe ausgabe;

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUntertitel() {
        return untertitel;
    }

    public void setUntertitel(String untertitel) {
        this.untertitel = untertitel;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Ausgabe getAusgabe() {
        return ausgabe;
    }

    public void setAusgabe(Ausgabe ausgabe) {
        this.ausgabe = ausgabe;
    }

}
