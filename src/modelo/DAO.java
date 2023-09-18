/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;

/**
 *
 * @author 2dam
 */
public interface DAO {

    public void crearConvocatoria(Convocatoria con);

    public Convocatoria consultarConvocatoria(String id);
}
