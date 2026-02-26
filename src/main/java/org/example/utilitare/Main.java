package org.example.utilitare;

import org.example.database.PacientDAO;
import org.example.model.Pacient;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PacientDAO dao = new PacientDAO();
        try {
            Pacient p = new Pacient(0, "Maria Popescu", "maria@example.com", "parola123",
                    "Trecut cu probleme cardiace", "penicilină", new ArrayList<>());


            boolean inserat = dao.adaugaPacientDacaNuExista(p);

            if (inserat) {
                System.out.println("Pacient adăugat cu succes!");
            } else {
                System.out.println("Pacientul cu emailul " + p.getEmail() + " există deja.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
