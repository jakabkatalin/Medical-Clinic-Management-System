package org.example.database;

import org.example.model.Reteta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetetaDAO {

    public void adaugaReteta(Reteta reteta) throws SQLException {
        String sql = "INSERT INTO retete (pacient_id, descriere) VALUES (?, ?)";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reteta.getPacientId());
            ps.setString(2, reteta.getDescriere());
            ps.executeUpdate();
        }
    }

    public List<Reteta> getRetetePentruPacient(int pacientId) throws SQLException {
        List<Reteta> retete = new ArrayList<>();
        String sql = "SELECT * FROM retete WHERE pacient_id = ?";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pacientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    retete.add(new Reteta(
                            rs.getInt("id"),
                            rs.getInt("pacient_id"),
                            rs.getString("descriere")
                    ));
                }
            }
        }
        return retete;
    }
}
