package controlador;

import clases.Enunciado;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import java.util.List;
import modelo.DAO;
import modelo.Factoria;

/**
 * Esta clase es una capa entre la logica del negocio y la interaccion del
 * usuario
 *
 * @author Jason.
 */
public class Controlador {

    /**
     * Implementacion de la logica del negocio orientada a la base de datos.
     */
    private DAO daoBD = Factoria.getImplementacionBD();

    /**
     * Implementacion de la logica del negocio orientada a los ficheros.
     */
    private DAO daoFich = Factoria.getImplementacionFich();

    /**
     * Introduce un enunciado en la base de datos.
     *
     * @param enun el enunciado que se quiere insertar.
     * @throws ErrCrear gestiona un error a la hora de insertar datos en la base
     * de datos.
     */
    public void crearEnunciado(Enunciado enun) throws ErrCrear {
        daoBD.crearEnunciado(enun);
    }

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrConsultar gestiona un error a la hora de buscar datos en la
     * base de datos.
     */
    public List<Enunciado> listarEnunciados() throws ErrConsultar {
        return daoBD.listarEnunciados();
    }
}
