package controlador;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import excepciones.ErrExtra;
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
     * Guarda un enunciado en la base de datos.
     *
     * @param enun el enunciado que se va a guardar.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void crearEnunciado(Enunciado enun) throws ErrCrear, ErrExtra {
        daoBD.crearEnunciado(enun);
    }

    /**
     * Guarda un enunciado en la base de datos.
     *
     * @param uni la unidad que se va a introducir.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void crearUnidad(UnidadDidactica uni) throws ErrCrear, ErrExtra {
        daoBD.crearUnidad(uni);
    }

    /**
     * Guarda en un fichero una convocatoria.
     *
     * @param conv la convocatoria que se va a guardar.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void crearConvocatoria(Convocatoria conv) throws ErrCrear, ErrExtra {
        daoFich.crearConvocatoria(conv);
    }

    /**
     * Muestra todos los enunciados de la base de datos.
     *
     * @return todos los enunciados.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion..
     */
    public List<Enunciado> listarEnunciados() throws ErrConsultar, ErrExtra {
        return daoBD.listarEnunciados();
    }

    /**
     * Muestra todas las unidades didacticas de la base de datos.
     *
     * @return todas las unidades didacticas.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion.
     */
    public List<UnidadDidactica> listarUnidades() throws ErrConsultar, ErrExtra {
        return daoBD.listarUnidades();
    }

    /**
     * Muestra todas las convocatorias del fichero.
     *
     * @return todas las convocatorias.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrConsultar gestiona un error a la hora de consultar
     * informacion.
     */
    public List<Convocatoria> listarConvocatorias() throws ErrConsultar, ErrExtra {
        return daoFich.listarConvocatorias();
    }

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
    public Convocatoria consultarConvocatoria(String id) throws ErrConsultar, ErrExtra {
        return daoFich.consultarConvocatoria(id);
    }

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
    public void asignarUnidad(int unidad, int enunciado) throws ErrCrear, ErrExtra {
        daoBD.asignarUnidad(unidad, enunciado);
    }

    /**
     * Guarda en la convocatoria el identificador unico del enunciado al que
     * pertenece.
     *
     * @param convocatoria la convocatoria y todos sus datos.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    public void asignarEnunciado(Convocatoria convocatoria) throws ErrExtra, ErrCrear {
        daoFich.asignarEnunciado(convocatoria);
    }
}
