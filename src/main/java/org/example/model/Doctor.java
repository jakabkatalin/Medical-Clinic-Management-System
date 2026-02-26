package org.example.model;

import java.util.List;

public class Doctor extends Utilizator {
    private String specializare;

    public Doctor(int id, String nume, String email, String parola, String specializare) {
        super(id, nume, email, parola);
        this.specializare = specializare;
    }

    public String getSpecializare() { return specializare; }
    public void setSpecializare(String specializare) { this.specializare = specializare; }

    @Override
    public String getRol() {
        return "DOCTOR";
    }
}