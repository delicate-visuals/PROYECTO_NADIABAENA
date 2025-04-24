package com.trueconnect.trueconnectrecom.BBDD.DAO;

import com.trueconnect.trueconnectrecom.BBDD.BBDDConnector;
import com.trueconnect.trueconnectrecom.models.Recomendacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecomendacionDAO {
    public ArrayList<Recomendacion> GetAllRecomendaciones() throws SQLException {
        ArrayList<Recomendacion> invs = new ArrayList<>();

        String query = "SELECT * FROM recomendaciones";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            Recomendacion inv = new Recomendacion();
            inv.setIdRecomendacion(rs.getInt("idRecomendaciones"));
            inv.setNombre(rs.getString("nombre"));
            inv.setDescripcion(rs.getString("descripcion"));

            invs.add(inv);
        }

        return invs;
    }

    public Recomendacion GetRecomendacionById(int id) throws SQLException {
        Recomendacion inv = null;
        String query = "SELECT idRecomendaciones, nombre, descripcion FROM recomendaciones WHERE idRecomendaciones = ?";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            inv = new Recomendacion();
            inv.setIdRecomendacion(rs.getInt("idRecomendaciones"));
            inv.setNombre(rs.getString("nombre"));
            inv.setDescripcion(rs.getString("descripcion"));
        }

        return inv;
    }

    public boolean AddRecomendacion(Recomendacion Recomendacion) throws SQLException {
        String query = "INSERT INTO recomendaciones (nombre, descripcion) VALUES (?, ?)";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Recomendacion.getNombre());
        ps.setString(2, Recomendacion.getDescripcion());

        int rows = ps.executeUpdate();
        return rows > 0;
    }

    public boolean UpdateRecomendacion(Recomendacion Recomendacion) throws SQLException {
        String query = "UPDATE recomendaciones SET nombre = ?, descripcion = ? WHERE idRecomendaciones = ?";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Recomendacion.getNombre());
        ps.setString(2, Recomendacion.getDescripcion());
        ps.setInt(3, Recomendacion.getIdRecomendacion());

        int rows = ps.executeUpdate();
        return rows > 0;

    }

    public boolean DeleteRecomendacion(int id) throws SQLException {
        String query = "DELETE FROM recomendaciones WHERE idRecomendaciones = ?";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        return rows > 0;
    }

}
