package modelo;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
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

    public void crearUnidad(UnidadDidactica uni) throws ErrCrear;

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrConsultar gestiona un error a la hora de buscar datos en la
     * base de datos.
     */
    public List<Enunciado> listarEnunciados() throws ErrConsultar;

    public List<Convocatoria> listarConvocatorias() throws ErrConsultar;

    public List<UnidadDidactica> listarUnidades() throws ErrConsultar;

    public void crearConvocatoria(Convocatoria con);

    public Convocatoria consultarConvocatoria(String id);

    public void asignarUnidad(int unidad, int enunciado) throws ErrCrear;

    public void asignarEnunciado(int enunciado, int convocatoria) throws ErrCrear;
}
