package org.example.model;

import java.util.List;

public class Medic extends Utilizator {
    private String specializare;
    private List<Programare> programari;

    public Medic(int id, String nume, String email, String parola, String specializare, List<Programare> programari) {
        super(id, nume, email, parola);
        this.specializare = specializare;
        this.programari = programari;
    }

    public String getSpecializare() {
        return specializare;
    }
    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
    public List<Programare> getProgramari() {
        return programari;
    }
    public void setProgramari(List<Programare> programari) {
        this.programari = programari;
    }

    @Override
    public String getRol() {
        return "MEDIC";
    }
}
