/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Enunciado;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import java.util.List;
import modelo.DAO;
import modelo.Factoria;

/**
 *
 * @author Jason.
 */
public class Controlador {

    DAO daoBD = Factoria.getImplementacionBD();
    DAO daoFich = Factoria.getImplementacionFich();

    public void crearEnunciado(Enunciado enun) throws ErrCrear {
        daoBD.crearEnunciado(enun);
    }

    public List<Enunciado> listarEnunciados() throws ErrConsultar {
        return daoBD.listarEnunciados();
    }
}
