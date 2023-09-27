package excepciones;

import javax.swing.JOptionPane;

/**
 * * Genera una excepcion por si hay un error a la hora de consultar
 * informacion en una base de datos o en un fichero.
 *
 * @author Jason.
 */
public class ErrConsultar extends Exception {

    private String mensaje;

    /**
     * Dependiendo de cual a sido la causa generamos un error u otro.
     *
     * @param causa
     */
    public ErrConsultar(String causa) {
        switch (causa) {
            case "Convocatoria":
                mensaje = "Ha ocurrido un error a la hora de consultar datos sobre convocatorias";
                break;
            case "Enunciado":
                mensaje = "Ha ocurrido un error a la hora de consultar datos sobre enunciados";
                break;
            case "UnidadDidactica":
                mensaje = "Ha ocurrido un error a la hora de consultar datos sobre unidades didacticas";
                break;
            default:
                mensaje = "Ha ocurrido un error a la hora de consultar algun dato";
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
