/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Enunciado;
import clases.UnidadDidactica;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2dam
 */
public class DaoImplementacion implements Dao{
    
    private Connection con;
    private PreparedStatement stmt;
    
    private final String INSERT_UNIDAD_DIDACTICA = "INSERT INTO unidad (id, acronimo, titulo, evaluacion, descripcion) VALUES ( ?, ?, ?, ?,?)";
    private final String SELECT_ENUNCIADO = "SELECT * FROM enunciado;";
    
public void abrirConexion(){
    
   
        try {
            Properties configBDA = new Properties();
            FileInputStream fis = new FileInputStream("configBDA.properties");
            configBDA.load(fis);
            
            final String URL = configBDA.getProperty("url");
            final String USER = configBDA.getProperty("user");
            final String PASSWORD = configBDA.getProperty("password");
            
            con = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DaoImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DaoImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   private void closeConnection() {
		
                    try {
                        if (stmt != null) {
                        stmt.close();
                        }
                        if (con != null){
			con.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(DaoImplementacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		
   public void crearUnidad(UnidadDidactica uni){
           this.abrirConexion();
           
        try {
            stmt = (PreparedStatement) con.prepareStatement(INSERT_UNIDAD_DIDACTICA);
            
            stmt.setInt(1, uni.getId());
            stmt.setString(2, uni.getAcronimo());
            stmt.setString(3, uni.getTitulo());
            stmt.setString(4, uni.getEvaluacion());
            stmt.setString(5, uni.getDescripcion());
            stmt.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }this.closeConnection();
           
           }

    /**
     *
     * @return
     */
   public List<Enunciado> visualizarEnunciado(){
       this.abrirConexion();
       Enunciado enun;
       List<Enunciado> idEnun = new ArrayList<>();
       ResultSet rs;
       
        try {
            stmt = (PreparedStatement) con.prepareStatement(SELECT_ENUNCIADO);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                    enun = new Enunciado();
                    enun.setId(rs.getInt("id"));
                    enun.setDescripcion(rs.getString("descripcion"));
                    
                    enun.setDisponible(rs.getBoolean("disponible"));
                    enun.setRuta(rs.getString("ruta"));
                    idEnun.add(enun);
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }this.closeConnection();
        return idEnun;
       
   }

    @Override
    public void crearEnunciado(Enunciado enun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
