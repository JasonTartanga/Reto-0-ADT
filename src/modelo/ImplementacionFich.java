package modelo;

import clases.Enunciado;
import java.util.List;

/**
 * Esta calse es la implementacion de la logica de negocio orientada a los
 * ficheros.
 *
 * @author Jason.
 */
public class ImplementacionFich implements DAO {

    /**
     * Inserta un enunciado en la base de datos.
     *
     * @param enun el enunciado que se va a intrducir.
     * @throws ErrCrear gestiona un error a la hora de insertar datos en la base
     * de datos.
     */
    @Override
    public void crearEnunciado(Enunciado enun) {

    }

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrConsultar gestiona un error a la hora de buscar datos en la
     * base de datos.
     */
    @Override
    public List<Enunciado> listarEnunciados() {
        return null;
    }

}
