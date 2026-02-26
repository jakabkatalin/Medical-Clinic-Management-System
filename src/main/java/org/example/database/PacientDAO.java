package org.example.database;

import org.example.model.Pacient;
import org.example.model.Tratament;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientDAO {

    public void adaugaPacient(Pacient pacient) throws SQLException {
        String sql = "INSERT INTO pacienti (nume, email, parola, istoric_medical, alergii) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pacient.getNume());
            ps.setString(2, pacient.getEmail());
            ps.setString(3, pacient.getParola());
            ps.setString(4, pacient.getIstoricMedical());
            ps.setString(5, pacient.getAlergii());
            ps.executeUpdate();
        }
    }

    public Pacient cautaPacientDupaEmail(String email) throws SQLException {
        String sql = "SELECT * FROM pacienti WHERE email = ?";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pacient(
                            rs.getInt("id"),
                            rs.getString("nume"),
                            rs.getString("email"),
                            rs.getString("parola"),
                            rs.getString("istoric_medical"),
                            rs.getString("alergii"),
                            new ArrayList<>()
                    );
                }
            }
        }
        return null;
    }

    public void actualizeazaPacient(Pacient pacient) throws SQLException {
        String sql = "UPDATE pacienti SET nume = ?, parola = ?, istoric_medical = ?, alergii = ? WHERE email = ?";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pacient.getNume());
            ps.setString(2, pacient.getParola());
            ps.setString(3, pacient.getIstoricMedical());
            ps.setString(4, pacient.getAlergii());
            ps.setString(5, pacient.getEmail());
            ps.executeUpdate();
        }
    }

    public void stergePacientDupaEmail(String email) throws SQLException {
        String sql = "DELETE FROM pacienti WHERE email = ?";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.executeUpdate();
        }
    }

    public List<Pacient> getToatePacientii() throws SQLException {
        List<Pacient> pacienti = new ArrayList<>();
        String sql = "SELECT * FROM pacienti";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pacienti.add(new Pacient(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("email"),
                        rs.getString("parola"),
                        rs.getString("istoric_medical"),
                        rs.getString("alergii"),
                        new ArrayList<>()
                ));
            }
        }
        return pacienti;
    }
    public boolean existaPacientCuEmail(String email) throws SQLException {
        String sql = "SELECT 1 FROM pacienti WHERE email = ?";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    public boolean adaugaPacientDacaNuExista(Pacient pacient) throws SQLException {
        if (!existaPacientCuEmail(pacient.getEmail())) {
            adaugaPacient(pacient);
            return true;
        } else {
            System.out.println("Pacient cu email " + pacient.getEmail() + " deja exista.");
            return false;
        }
    }
    /*public boolean adaugaPacient(Pacient pacient) throws SQLException {
        String sql = "INSERT INTO pacienti (nume, email, parola, istoric_medical, alergii) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexiuneDataBase.getInstance().getConexiune();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pacient.getNume());
            ps.setString(2, pacient.getEmail());
            ps.setString(3, pacient.getParola());
            ps.setString(4, pacient.getIstoricMedical());
            ps.setString(5, pacient.getAlergii());
            ps.executeUpdate();
            return true;
        } catch (PSQLException e) {
            if (e.getSQLState().equals("23505")) {
                return false;
            } else {
                throw e;
            }
        }
    }*/

}  