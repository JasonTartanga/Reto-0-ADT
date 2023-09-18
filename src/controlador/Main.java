/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.DAO;
import modelo.DAOImplementacionFichero;
import vista.ConvocatoriaVentana;

/**
 *
 * @author 2dam
 */
public class Main {

    public static void main(String[] args) {
        DAO dao = new DAOImplementacionFichero();

        ConvocatoriaVentana cv = new ConvocatoriaVentana(null, true, dao);
        cv.setVisible(true);
    }

}
