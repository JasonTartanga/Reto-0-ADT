/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VMain;

/**
 * Es el Main de la aplicacion.
 *
 * @author Jason.
 */
public class App {

    /**
     * Este metodo inicia la app.
     *
     * @param args
     */
    public static void main(String[] args) {
        VMain vMain = new VMain(new Controlador());
        vMain.setVisible(true);
    }
}
