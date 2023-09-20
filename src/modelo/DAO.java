package modelo;

import clases.Enunciado;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import java.util.List;

/**
 * Es la logica del negocio.
 *
 * @author Jason.
 */
public interface DAO {

    /**
     * Inserta un enunciado en la base de datos.
     *
     * @param enun el enunciado que se va a intrducir.
     * @throws ErrCrear gestiona un error a la hora de insertar datos en la base
     * de datos.
     */
    public void crearEnunciado(Enunciado enun) throws ErrCrear;

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrConsultar gestiona un error a la hora de buscar datos en la
     * base de datos.
     */
    public List<Enunciado> listarEnunciados() throws ErrConsultar;
}
