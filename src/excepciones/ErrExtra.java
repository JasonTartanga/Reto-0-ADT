package excepciones;

import javax.swing.JOptionPane;

/**
 * * Genera una excepcion por si hay un error a la extra.
 *
 * @author Jason.
 */
public class ErrExtra extends Exception {

    private String mensaje;

    /**
     * Dependiendo de cual a sido la causa generamos un error u otro.
     *
     * @param causa
     */
    public ErrExtra(String causa) {
        switch (causa) {
            case "SQL":
                mensaje = "Ha ocurrido un error a la hora de conectarse con la base de datos";
                break;
            case "Fichero":
                mensaje = "Ha ocurrido un error con algun fichero";
                break;
            default:
                mensaje = "Ha ocurrido un error inesperado";
                break;
        }
    }

    /**
     * Muestra el error por pantalla.
     */
    public void mostrarError() {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
