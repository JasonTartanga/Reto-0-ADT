package excepciones;

import javax.swing.JOptionPane;

/**
 * Genera una excepcion por si hay un error a la hora de guardar informacion en
 * una base de datos o en un fichero.
 *
 * @author Jason.
 */
public class ErrCrear extends Exception {

    private String mensaje;

    /**
     * Dependiendo de cual a sido la causa generamos un error u otro.
     *
     * @param causa
     */
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
            default:
                mensaje = "Ha ocurrido un error a la hora de crear algun dato";
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
