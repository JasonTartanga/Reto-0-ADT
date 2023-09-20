/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jason.
 */
public class Factoria {

    public static Dao getImplementacionBD() {
        return new DaoImplementacion();
    }

    public static Dao getImplementacionFich() {
        return new ImplementacionFich();
    }

}
