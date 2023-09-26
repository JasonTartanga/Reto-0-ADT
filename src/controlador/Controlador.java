package controlador;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
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

    public Convocatoria consultarConvocatoria(String id) throws ErrConsultar {
        return daoFich.consultarConvocatoria(id);
    }

    public void crearConvocatoria(Convocatoria conv) throws ErrCrear {
        daoFich.crearConvocatoria(conv);
    }

    /**
     * Introduce un enunciado en la base de datos.
     *
     * @param uni
     * @param enun el enunciado que se quiere insertar.
     * @throws ErrCrear gestiona un error a la hora de insertar datos en la base
     * de datos.
     */
    public void crearUnidad(UnidadDidactica uni) throws ErrCrear {
        daoBD.crearUnidad(uni);
    }

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

    public List<Convocatoria> listarConvocatorias() throws ErrConsultar {
        return daoFich.listarConvocatorias();
    }

    public List<UnidadDidactica> listarUnidades() throws ErrConsultar {
        return daoBD.listarUnidades();
    }

    public void asignarUnidad(int unidad, int enunciado) throws ErrCrear {
        daoBD.asignarUnidad(unidad, enunciado);
    }
}
