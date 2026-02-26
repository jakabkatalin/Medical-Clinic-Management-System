package org.example.model;

public class Diagnostic {
private int id;
private String descriere;
private Programare programare;

public Diagnostic(int id, String descriere, Programare programare) {
    this.id = id;
    this.descriere = descriere;
    this.programare = programare;
}
public int getId() { return id; }
public String getDescriere() { return descriere; }
public Programare getProgramare() { return programare; }
}