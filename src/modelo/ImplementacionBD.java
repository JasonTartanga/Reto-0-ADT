package modelo;

import clases.Convocatoria;
import clases.Dificultad;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import excepciones.ErrExtra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Esta calse es la implementacion de la logica de negocio orientada a la base
 * de datos.
 *
 * @author Jason.
 */
public class ImplementacionBD implements DAO {

    private Connection con = null;
    private PreparedStatement stmt;

    private final String INSERT_UNIDAD_DIDACTICA = "INSERT INTO unidad (id, acronimo, titulo, evaluacion, descripcion) VALUES ( ?, ?, ?, ?,?)";
    private final String CREAR_ENUNCIADO = "INSERT INTO enunciado VALUES (?, ?, ?, ?, ?)";
    private final String LISTAR_ENUNCIADOS = "SELECT * FROM enunciado";
    private final String LISTAR_UNIDADES_DIDACTICAS = "SELECT * FROM unidad";

    private final String ASIGNAR_UNIDAD = "INSERT INTO unidad_enunciado VALUES (?, ?)";

    /**
     * Este metodo abre una conexion con la base de datos mediante un archivo de
     * configuracion .propeties.
     */
    public void abrirConexion() throws ErrExtra {
        try {
            final String URL = ResourceBundle.getBundle("modelo.configBDA").getString("url");
            final String USER = ResourceBundle.getBundle("modelo.configBDA").getString("user");
            final String PASSWORD = ResourceBundle.getBundle("modelo.configBDA").getString("password");

            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new ErrExtra("SQL");
        }
    }

    /**
     * Este metodo cierra la conexion con la base de datos.
     */
    public void cerrarConexion() throws ErrExtra {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new ErrExtra("SQL");
        }
    }

    /**
     * Guarda un enunciado en la base de datos.
     *
     * @param enun el enunciado que se va a guardar.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    @Override
    public void crearEnunciado(Enunciado enun) throws ErrCrear, ErrExtra {
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
            throw new ErrCrear("Enunciado");
        }
        this.cerrarConexion();
    }

    /**
     * Guarda un enunciado en la base de datos.
     *
     * @param uni la unidad que se va a introducir.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    @Override
    public void crearUnidad(UnidadDidactica uni) throws ErrCrear, ErrExtra {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(INSERT_UNIDAD_DIDACTICA);

            stmt.setInt(1, uni.getId());
            stmt.setString(2, uni.getAcronimo());
            stmt.setString(3, uni.getTitulo());
            stmt.setString(4, uni.getEvaluacion());
            stmt.setString(5, uni.getDescripcion());
            System.out.println(stmt);
            stmt.execute();

        } catch (SQLException ex) {
            throw new ErrCrear("UnidadDidactica");
        }
        this.cerrarConexion();

    }

    @Override
    public void crearConvocatoria(Convocatoria con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion..
     */
    @Override
    public List<Enunciado> listarEnunciados() throws ErrConsultar, ErrExtra {
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
            throw new ErrConsultar("Enunciado");
        }
        this.cerrarConexion();
        return enunciados;
    }

    /**
     * Muestra todas las unidades didacticas de la base de datos.
     *
     * @return todas las unidades didacticas.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion.
     */
    @Override
    public List<UnidadDidactica> listarUnidades() throws ErrConsultar, ErrExtra {
        List<UnidadDidactica> unidades = new ArrayList<>();
        this.abrirConexion();
        try {
            stmt = con.prepareStatement(LISTAR_UNIDADES_DIDACTICAS);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UnidadDidactica u = new UnidadDidactica();
                u.setId(rs.getInt("id"));
                u.setAcronimo(rs.getString("acronimo"));
                u.setTitulo(rs.getString("titulo"));
                u.setEvaluacion(rs.getString("evaluacion"));
                u.setDescripcion(rs.getString("descripcion"));
                unidades.add(u);
            }
        } catch (SQLException e) {
            throw new ErrConsultar("Unidad");
        }
        this.cerrarConexion();
        return unidades;
    }

    @Override
    public List<Convocatoria> listarConvocatorias() throws ErrConsultar {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Convocatoria consultarConvocatoria(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Guarda en la base de datos que enunciado pertenece a que unidad
     * didactica.
     *
     * @param unidad el identificador unico de unidad didactica.
     * @param enunciado el identificador unico del enunciado.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    @Override
    public void asignarUnidad(int unidad, int enunciado) throws ErrCrear, ErrExtra {
        this.abrirConexion();
        try {
            stmt = con.prepareStatement(ASIGNAR_UNIDAD);
            stmt.setInt(1, unidad);
            stmt.setInt(2, enunciado);
            stmt.execute();
        } catch (SQLException e) {
            throw new ErrCrear("Unidad");
        }
        this.cerrarConexion();
    }

    @Override
    public void asignarEnunciado(Convocatoria convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
