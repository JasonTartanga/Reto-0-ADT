/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import java.util.List;

/**
 *
 * @author Jason.
 */
public interface DAO {

    public void crearEnunciado(Enunciado enun) throws ErrCrear;
     
    public void crearUnidad(UnidadDidactica uni) throws ErrCrear;
    
    public List<Enunciado> listarEnunciados() throws ErrConsultar;

    
}
