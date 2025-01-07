package com.gestionCoches.app.dao;

import com.gestionCoches.app.database.DBConnection;
import com.gestionCoches.app.model.Pasajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {

    public void insertarPasajero(Pasajero pasajero) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "INSERT INTO pasajeros (nombre, edad, peso, coche_id) VALUES (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setInt(2, pasajero.getEdad());
            ps.setDouble(3, pasajero.getPeso());
            ps.setInt(4, pasajero.getCocheId());
            // Si no quieres asignar coche aún, podrías poner un valor nulo o 0 en cocheId,
            // y luego tratarlo lógicamente (ej.: ps.setObject(4, null)).

            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }

    public int borrarPasajero(int id) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "DELETE FROM pasajeros WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public Pasajero consultarPasajeroPorId(int id) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM pasajeros WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setId(rs.getInt("id"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setEdad(rs.getInt("edad"));
                pasajero.setPeso(rs.getDouble("peso"));
                pasajero.setCocheId(rs.getInt("coche_id"));
                return pasajero;
            }
            return null;

        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }

    public int modificarPasajero(Pasajero pasajero) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "UPDATE pasajeros SET nombre=?, edad=?, peso=?, coche_id=? WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, pasajero.getNombre());
            ps.setInt(2, pasajero.getEdad());
            ps.setDouble(3, pasajero.getPeso());
            ps.setInt(4, pasajero.getCocheId());
            ps.setInt(5, pasajero.getId());

            return ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Pasajero> listarPasajeros() throws SQLException {
        List<Pasajero> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM pasajeros";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setId(rs.getInt("id"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setEdad(rs.getInt("edad"));
                pasajero.setPeso(rs.getDouble("peso"));
                pasajero.setCocheId(rs.getInt("coche_id"));
                lista.add(pasajero);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return lista;
    }

    public int asignarPasajeroACoche(int pasajeroId, int cocheId) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "UPDATE pasajeros SET coche_id=? WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cocheId);
            ps.setInt(2, pasajeroId);

            return ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public int eliminarPasajeroDeCoche(int pasajeroId) throws SQLException {
        PreparedStatement ps = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "UPDATE pasajeros SET coche_id=NULL WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pasajeroId);

            return ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Pasajero> listarPasajerosDeCoche(int cocheId) throws SQLException {
        List<Pasajero> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String sql = "SELECT * FROM pasajeros WHERE coche_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cocheId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pasajero pasajero = new Pasajero();
                pasajero.setId(rs.getInt("id"));
                pasajero.setNombre(rs.getString("nombre"));
                pasajero.setEdad(rs.getInt("edad"));
                pasajero.setPeso(rs.getDouble("peso"));
                pasajero.setCocheId(rs.getInt("coche_id"));
                lista.add(pasajero);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return lista;
    }
}
