package org.example.model;

public class Reteta {
    private int id;
    private int pacientId;
    private String descriere;

    public Reteta(int id, int pacientId, String descriere) {
        this.id = id;
        this.pacientId = pacientId;
        this.descriere = descriere;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPacientId() {
        return pacientId;
    }
    public void setPacientId(int pacientId) {
        this.pacientId = pacientId;
    }
    public String getDescriere() {
        return descriere;
    }
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
}
