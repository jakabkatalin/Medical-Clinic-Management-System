package org.example.database;

import org.example.model.Medic;
import org.example.model.Pacient;
import org.example.model.Programare;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ProgramareDAO {

    public void adaugaProgramare(Programare programare) throws SQLException {
        String sql = "INSERT INTO programari (data_programare, ora_programare, pacient_id, medic_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(programare.getData()));
            ps.setTime(2, Time.valueOf(programare.getOra()));
            ps.setInt(3, programare.getPacient().getId());
            ps.setInt(4, programare.getMedic().getId());
            ps.executeUpdate();
        }
    }

    public List<Programare> getProgramariFiltrate(LocalDate data, Integer medicId) throws SQLException {
        List<Programare> programari = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT p.id, p.data_programare, p.ora_programare, " +
                "pac.id AS pacient_id, pac.nume AS pacient_nume, pac.email AS pacient_email, pac.parola AS pacient_parola, pac.istoric_medical, pac.alergii, " +
                "m.id AS medic_id, m.nume AS medic_nume, m.email AS medic_email, m.parola AS medic_parola, m.specializare " +
                "FROM programari p " +
                "JOIN pacienti pac ON p.pacient_id = pac.id " +
                "JOIN medici m ON p.medic_id = m.id " +
                "WHERE 1=1 ");

        if (data != null) {
            sql.append("AND p.data_programare = ? ");
        }
        if (medicId != null) {
            sql.append("AND p.medic_id = ? ");
        }

        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int index = 1;
            if (data != null) {
                ps.setDate(index++, Date.valueOf(data));
            }
            if (medicId != null) {
                ps.setInt(index, medicId);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pacient pacient = new Pacient(
                            rs.getInt("pacient_id"),
                            rs.getString("pacient_nume"),
                            rs.getString("pacient_email"),
                            rs.getString("pacient_parola"),
                            rs.getString("istoric_medical"),
                            rs.getString("alergii"),
                            null
                    );
                    Medic medic = new Medic(
                            rs.getInt("medic_id"),
                            rs.getString("medic_nume"),
                            rs.getString("medic_email"),
                            rs.getString("medic_parola"),
                            rs.getString("specializare"),
                            null
                    );
                    Programare programare = new Programare(
                            rs.getInt("id"),
                            rs.getDate("data_programare").toLocalDate(),
                            rs.getTime("ora_programare").toLocalTime(),
                            pacient,
                            medic
                    );
                    programari.add(programare);
                }
            }
        }
        return programari;
    }
}
