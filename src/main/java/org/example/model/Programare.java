package org.example.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Programare {
    private int id;
    private LocalDate data;
    private LocalTime ora;
    private Pacient pacient;
    private Medic medic;

    public Programare(int id, LocalDate data, LocalTime ora, Pacient pacient, Medic medic) {
        this.id = id;
        this.data = data;
        this.ora = ora;
        this.pacient = pacient;
        this.medic = medic;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalTime getOra() {
        return ora;
    }
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }
    public Pacient getPacient() {
        return pacient;
    }
    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }
    public Medic getMedic() {
        return medic;
    }
    public void setMedic(Medic medic) {
        this.medic = medic;
    }
}