/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Jason.
 */
public class ErrCrear extends Exception {

    private String mensaje;

    public ErrCrear(String causa) {
        switch (causa) {
            case "Convocatoria":
                mensaje = "Ha ocurrido un error a la hora de crear una convocatoria";
                break;
            case "Enunciado":
                mensaje = "Ha ocurrido un error a la hora de crear un enunciado";
                break;
            case "UnidadDidactica":
                mensaje = "Ha ocurrido un error a la hora de crear una unidad didactica";
                break;
        }
    }

    public void mostrarError() {
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
