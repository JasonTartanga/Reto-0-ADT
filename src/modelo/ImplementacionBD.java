        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Dificultad;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason.
 */
public class ImplementacionBD implements DAO {

    private Connection con = null;
    private PreparedStatement stmt;

    private final String INSERT_UNIDAD_DIDACTICA = "INSERT INTO unidad (id, acronimo, titulo, evaluacion, descripcion) VALUES ( ?, ?, ?, ?,?)";
    private final String CREAR_ENUNCIADO = "INSERT INTO enunciado VALUES (?, ?, ?, ?, ?)";
    private final String LISTAR_ENUNCIADOS = "SELECT * FROM enunciado";

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

    /**
     *
     * @param uni
     * @throws ErrCrear
     */
    @Override
 public void crearUnidad(UnidadDidactica uni) throws ErrCrear{
           this.abrirConexion();
           
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(INSERT_UNIDAD_DIDACTICA);
            
            stmt.setInt(1, uni.getId());
            stmt.setString(2, uni.getAcronimo());
            stmt.setString(3, uni.getTitulo());
            stmt.setString(4, uni.getEvaluacion());
            stmt.setString(5, uni.getDescripcion());
            stmt.executeUpdate();
           
        } catch (SQLException ex) {
            throw new ErrCrear("Error a la hora de crear una unidad didactica");
        }this.cerrarConexion();
           
           }
    @Override
    public void crearEnunciado(Enunciado enun) throws ErrCrear {
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
            throw new ErrCrear("Error a la hora de crear un enunciado");
        }
        this.cerrarConexion();
    }

    @Override
    public List<Enunciado> listarEnunciados() throws ErrConsultar {
        List<Enunciado> enunciados = new ArrayList<>();
        this.abrirConexion();
        try {
            stmt = con.prepareStatement(LISTAR_ENUNCIADOS);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Enunciado e = new Enunciado();
                e.setId(rs.getInt("id"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setDisponible(rs.getBoolean("disponible"));
                e.setRuta(rs.getString("ruta"));

                if (rs.getString("nivel").equalsIgnoreCase("alta")) {
                    e.setNivel(Dificultad.ALTA);

                } else if (rs.getString("nivel").equalsIgnoreCase("media")) {
                    e.setNivel(Dificultad.MEDIA);

                } else {
                    e.setNivel(Dificultad.BAJA);
                }

                enunciados.add(e);
            }
        } catch (SQLException e) {
            throw new ErrConsultar("Error a la hora de consultar un error");
        }
        this.cerrarConexion();
        return enunciados;
    }

    

}
