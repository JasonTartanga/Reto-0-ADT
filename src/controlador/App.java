/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.CrearEnunciado;

/**
 *
 * @author Jason.
 */
public class App {

    public static void main(String[] args) {
        Controlador con = new Controlador();
        CrearEnunciado ce = new CrearEnunciado(null, true, con);
        ce.setVisible(true);
    }
}
