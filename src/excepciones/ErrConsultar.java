package excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Jason.
 */
public class ErrConsultar extends Exception {

    private String mensaje;

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
        }
    }

    public void mostrarError() {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
