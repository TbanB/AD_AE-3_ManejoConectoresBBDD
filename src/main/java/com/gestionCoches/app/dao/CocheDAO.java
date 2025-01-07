package com.gestionCoches.app.dao;

import com.gestionCoches.app.database.DBConnection;
import com.gestionCoches.app.model.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CocheDAO {

    public void insertarCoche(Coche coche) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "INSERT INTO coches (marca, modelo, cv, precio) VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, coche.getMarca());
            ps.setString(2, coche.getModelo());
            ps.setInt(3, coche.getCv());
            ps.setInt(4, coche.getPrecio());

            ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public int borrarCoche(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "DELETE FROM coches WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public Coche consultarCochePorId(int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM coches WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                Coche coche = new Coche();
                coche.setId(rs.getInt("id"));
                coche.setMarca(rs.getString("marca"));
                coche.setModelo(rs.getString("modelo"));
                coche.setCv(rs.getInt("cv"));
                coche.setPrecio(rs.getInt("precio"));
                return coche;
            } else {
                return null;
            }

        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }

    public int modificarCoche(Coche coche) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "UPDATE coches SET marca=?, modelo=?, cv=?, precio=? WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, coche.getMarca());
            ps.setString(2, coche.getModelo());
            ps.setInt(3, coche.getCv());
            ps.setInt(4, coche.getPrecio());
            ps.setInt(5, coche.getId());

            return ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Coche> listarCoches() throws SQLException {
        List<Coche> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM coches";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Coche coche = new Coche();
                coche.setId(rs.getInt("id"));
                coche.setMarca(rs.getString("marca"));
                coche.setModelo(rs.getString("modelo"));
                coche.setCv(rs.getInt("cv"));
                coche.setPrecio(rs.getInt("precio"));
                lista.add(coche);
            }

        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return lista;
    }
}
