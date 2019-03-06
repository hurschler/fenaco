package com.fenaco.ua.ufarevue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.jsoup.nodes.Node;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String vorname;

    public Autor(String autorName) {
        this.name = autorName;
    }

    public Autor(Node node) {
        node.attributes();
        String s = node.childNode(0).toString();
        s = s.replace("Autorin ", "");
        s = s.replace("Autor ", "");
        s = s.replace("Autoren ", "");
        s = s.replace("Autorinnen ", "");
        s = s.replace("Dr. ", "");
        s = s.substring(0, s.indexOf(","));
        String vorname = s.substring(0, s.indexOf(" "));
        String nachname = s.substring(s.indexOf(" "), s.length());
        this.name = nachname;
        this.vorname = vorname;
    }

    public Autor() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

}
