/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excepciones;

/**
 *
 * @author Jason.
 */
public class ErrConsultar extends Exception {

    /**
     * Creates a new instance of <code>ErrConsultar</code> without detail message.
     */
    public ErrConsultar() {
    }


    /**
     * Constructs an instance of <code>ErrConsultar</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ErrConsultar(String msg) {
        super(msg);
    }
}
