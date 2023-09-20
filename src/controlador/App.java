/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VMain;

/**
 *
 * @author Jason.
 */
public class App {

    public static void main(String[] args) {
        VMain vMain = new VMain(new Controlador());
        vMain.setVisible(true);
    }
}
