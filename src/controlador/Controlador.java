/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Enunciado;
import modelo.Dao;
import modelo.Factoria;

/**
 *
 * @author Jason.
 */
public class Controlador {

    Dao daoBD = Factoria.getImplementacionBD();
    Dao daoFich = Factoria.getImplementacionFich();

    public void crearEnunciado(Enunciado enun) {
        daoBD.crearEnunciado(enun);
    }
}
