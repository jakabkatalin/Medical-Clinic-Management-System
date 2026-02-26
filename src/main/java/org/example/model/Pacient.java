package org.example.model;

import java.util.List;

public class Pacient extends Utilizator {
    private String istoricMedical;
    private String alergii;
    private List<Tratament> tratamente;

    public Pacient(int id, String nume, String email, String parola, String istoricMedical, String alergii, List<Tratament> tratamente) {
        super(id, nume, email, parola);
        this.istoricMedical = istoricMedical;
        this.alergii = alergii;
        this.tratamente = tratamente;
    }

    public String getIstoricMedical() {
        return istoricMedical;
    }
    public void setIstoricMedical(String istoricMedical) {
        this.istoricMedical = istoricMedical;
    }
    public String getAlergii() {
        return alergii;
    }
    public void setAlergii(String alergii) {
        this.alergii = alergii;
    }
    public List<Tratament> getTratamente() {
        return tratamente;
    }
    public void setTratamente(List<Tratament> tratamente) {
        this.tratamente = tratamente;
    }

    @Override
    public String getRol() {
        return "PACIENT";
    }
}