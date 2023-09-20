/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Enunciado;
import clases.UnidadDidactica;
import java.util.List;

/**
 *
 * @author 2dam
 */
public interface Dao {
    
    public void crearUnidad(UnidadDidactica uni);
    public List<Enunciado> visualizarEnunciado();
    public void crearEnunciado(Enunciado enun);
}
