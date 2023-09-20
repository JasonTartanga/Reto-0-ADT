/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrCrear;
import java.util.List;

/**
 *
 * @author Jason.
 */
public class ImplementacionFich implements DAO {

    @Override
    public void crearEnunciado(Enunciado enun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enunciado> listarEnunciados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearUnidad(UnidadDidactica uni) throws ErrCrear {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
