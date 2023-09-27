package modelo;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import excepciones.ErrExtra;
import java.util.List;

/**
 * Es la logica del negocio.
 *
 * @author Jason.
 */
public interface DAO {

    /**
     * Guarda un enunciado en la base de datos.
     *
     * @param enun el enunciado que se va a guardar.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void crearEnunciado(Enunciado enun) throws ErrExtra, ErrCrear;

    /**
     * Guarda un enunciado en la base de datos.
     *
     * @param uni la unidad que se va a introducir.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void crearUnidad(UnidadDidactica uni) throws ErrExtra, ErrCrear;

    /**
     * Guarda en un fichero una convocatoria.
     *
     * @param conv la convocatoria que se va a guardar.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void crearConvocatoria(Convocatoria conv) throws ErrExtra, ErrCrear;

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion..
     */
    public List<Enunciado> listarEnunciados() throws ErrExtra, ErrConsultar;

    /**
     * Muestra todas las unidades didacticas de la base de datos.
     *
     * @return todas las unidades didacticas.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion.
     */
    public List<UnidadDidactica> listarUnidades() throws ErrExtra, ErrConsultar;

    /**
     * Muestra todas las convocatorias del fichero.
     *
     * @return todas las convocatorias.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion.
     */
    public List<Convocatoria> listarConvocatorias() throws ErrExtra, ErrConsultar;

    /**
     * Busca en el fichero la informacion de una convocatoria especifica.
     *
     * @param id el identificador unico de la convocatoria que se busca.
     * @return la convocatoria que tenga la id que le hemos pasado.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion.
     */
    public Convocatoria consultarConvocatoria(String id) throws ErrExtra, ErrConsultar;

    /**
     * Guarda en la base de datos que enunciado pertenece a que unidad
     * didactica.
     *
     * @param unidad el identificador unico de unidad didactica.
     * @param enunciado el identificador unico del enunciado.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void asignarUnidad(int unidad, int enunciado) throws ErrExtra, ErrCrear;

    /**
     * Guarda en la convocatoria el identificador unico del enunciado al que
     * pertenece.
     *
     * @param convocatoria la convocatoria con todos sus datos.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void asignarEnunciado(Convocatoria convocatoria) throws ErrExtra, ErrCrear;
}
