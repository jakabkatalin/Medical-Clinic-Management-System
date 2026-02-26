package org.example.database;

import org.example.model.Medic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicDAO {

    public void adaugaMedic(Medic medic) throws SQLException {
        String sql = "INSERT INTO medici (nume, email, parola, specializare) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, medic.getNume());
            ps.setString(2, medic.getEmail());
            ps.setString(3, medic.getParola());
            ps.setString(4, medic.getSpecializare());
            ps.executeUpdate();
        }
    }

    public Medic cautaMedicDupaEmail(String email) throws SQLException {
        String sql = "SELECT * FROM medici WHERE email = ?";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Medic(
                            rs.getInt("id"),
                            rs.getString("nume"),
                            rs.getString("email"),
                            rs.getString("parola"),
                            rs.getString("specializare"),
                            new ArrayList<>()
                    );
                }
            }
        }
        return null;
    }

    public List<Medic> getTotMedicii() throws SQLException {
        List<Medic> medici = new ArrayList<>();
        String sql = "SELECT * FROM medici";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                medici.add(new Medic(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("email"),
                        rs.getString("parola"),
                        rs.getString("specializare"),
                        new ArrayList<>()
                ));
            }
        }
        return medici;
    }
}
