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

    public static DAO getImplementacionBD() {
        return new ImplementacionBD();
    }

    public static DAO getImplementacionFich() {
        return new ImplementacionFich();
    }

}
