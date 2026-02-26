package org.example.model;

public class Tratament {
    private int id;
    private String denumire;
    private String descriere;

    public Tratament(int id, String denumire, String descriere) {
        this.id = id;
        this.denumire = denumire;
        this.descriere = descriere;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public String getDescriere() {
        return descriere;
    }
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
