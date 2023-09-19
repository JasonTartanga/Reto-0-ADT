/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Enunciado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Jason.
 */
public class ImplementacionBD implements DAO {

    private Connection con = null;
    private PreparedStatement stmt;

    private final String CREAR_ENUNCIADO = "INSERT INTO enunciado VALUES (?, ?, ?, ?, ?)";

    public void abrirConexion() {
        try {
            final String URL = ResourceBundle.getBundle("modelo.configBDA").getString("url");
            final String USER = ResourceBundle.getBundle("modelo.configBDA").getString("user");
            final String PASSWORD = ResourceBundle.getBundle("modelo.configBDA").getString("password");

            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crearEnunciado(Enunciado enun) {
        this.abrirConexion();
        try {
            stmt = con.prepareStatement(CREAR_ENUNCIADO);
            stmt.setInt(1, enun.getId());
            stmt.setString(2, enun.getDescripcion());
            stmt.setString(3, enun.getNivel() + "");
            stmt.setBoolean(4, enun.isDisponible());
            stmt.setString(5, enun.getRuta());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }

}
