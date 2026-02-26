package org.example.serviciu;

import org.example.database.PacientDAO;
import org.example.model.Pacient;

import java.sql.SQLException;
import java.util.List;

public class PacientService {
    private PacientDAO pacientDAO = new PacientDAO();

    public boolean inregistreazaPacient(Pacient pacient) {
        try {
            if (pacientDAO.cautaPacientDupaEmail(pacient.getEmail()) != null) {

                return false;
            }
            pacientDAO.adaugaPacient(pacient);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Pacient loginPacient(String email, String parola) {
        try {
            Pacient pacient = pacientDAO.cautaPacientDupaEmail(email);
            if (pacient != null && pacient.getParola().equals(parola)) {
                return pacient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean actualizeazaPacient(Pacient pacient) {
        try {
            if (pacientDAO.cautaPacientDupaEmail(pacient.getEmail()) == null) {

                return false;
            }
            pacientDAO.actualizeazaPacient(pacient);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stergePacient(String email) {
        try {
            if (pacientDAO.cautaPacientDupaEmail(email) == null) {

                return false;
            }
            pacientDAO.stergePacientDupaEmail(email);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Pacient> listaPacienti() {
        try {
            return pacientDAO.getToatePacientii();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
