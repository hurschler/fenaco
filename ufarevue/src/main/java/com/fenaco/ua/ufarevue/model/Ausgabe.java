package com.fenaco.ua.ufarevue.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ausgabe")
public class Ausgabe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String bezeichnung;
    private String jahr;
    private String sprache;

    public Ausgabe() {
        this.artikelList = new ArrayList<>();
    }

    private List<Artikel> artikelList;

    @OneToMany(targetEntity = Artikel.class, mappedBy = "ausgabe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Artikel> getArtikelList() {
        return artikelList;
    }

    public void setArtikelList(List<Artikel> artikelList) {
        this.artikelList = artikelList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addArtikel(Artikel artikel) {
        this.artikelList.add(artikel);
    }

    @Column(name = "bezeichnung", nullable = true)
    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Column(name = "jahr", nullable = true)
    public String getJahr() {
        return jahr;
    }

    public void setJahr(String jahr) {
        this.jahr = jahr;
    }

    @Column(name = "sprache", nullable = true)
    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

}
