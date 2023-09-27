package controlador;

import vista.VMain;

/**
 * Es el Main de la aplicacion.
 *
 * @author Jason.
 */
public class App {

    /**
     * Este metodo inicia la app.
     *
     * @param args
     */
    public static void main(String[] args) {
        VMain vMain = new VMain(new Controlador());
        vMain.setVisible(true);
    }
}
