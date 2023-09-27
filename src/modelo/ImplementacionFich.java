package modelo;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
import excepciones.ErrExtra;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import recursos.MyObjectOutputStream;

/**
 * * Esta calse es la implementacion de la logica de negocio orientada a los
 * ficheros.
 *
 * @author Niko.
 */
public class ImplementacionFich implements DAO {

    File fich = new File("convocatorias.dat");

    /**
     * Guarda en un fichero una convocatoria.
     *
     * @param conv la convocatoria que se va a guardar.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     */
    @Override
    public void crearConvocatoria(Convocatoria conv) throws ErrExtra {
        ObjectOutputStream oos = null;

        try {
            if (fich.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(fich, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fich));
            }

            oos.writeObject(conv);

        } catch (FileNotFoundException ex) {
            throw new ErrExtra("fichero");
        } catch (IOException ex) {
            throw new ErrExtra("fichero");
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                throw new ErrExtra("fichero");
            }
        }
    }

    /**
     * Busca en el fichero la informacion de una convocatoria especifica.
     *
     * @param id el identificador unico de la convocatoria que se busca.
     * @return la convocatoria que tenga la id que le hemos pasado.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     *
     */
    @Override
    public Convocatoria consultarConvocatoria(String id) throws ErrExtra {
        ObjectInputStream ois = null;
        Convocatoria convocatoria = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fich));

            while (true) {
                try {
                    Convocatoria conv = (Convocatoria) ois.readObject();

                    if (conv.getConvocatoria().equalsIgnoreCase(id)) {
                        convocatoria = conv;
                        break;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            throw new ErrExtra("fichero");
        } catch (ClassNotFoundException | IOException ex) {
            throw new ErrExtra("fichero");
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                throw new ErrExtra("fichero");
            }
        }
        return convocatoria;
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
    @Override
    public List<Convocatoria> listarConvocatorias() throws ErrConsultar, ErrExtra {
        List<Convocatoria> convocatorias = new ArrayList<>();
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(fich));
            Convocatoria conv = null;

            while (true) {
                try {
                    conv = (Convocatoria) ois.readObject();
                    convocatorias.add(conv);
                    System.out.println(conv.toString());

                } catch (EOFException e) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            throw new ErrExtra("fichero");
        } catch (IOException | ClassNotFoundException ex) {
            throw new ErrExtra("fichero");
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                throw new ErrExtra("fichero");
            }
        }
        return convocatorias;
    }

    /**
     * Guarda en la convocatoria el identificador unico del enunciado al que
     * pertenece.
     *
     * @param convocatoria la convocatoria con todos sus datos.
     * @throws ErrExtra gestiona un error a la hora de conectarse con la base de
     * datos.
     * @throws ErrCrear gestiona un error a la hora de guardar informacion.
     */
    @Override
    public void asignarEnunciado(Convocatoria convocatoria) throws ErrCrear, ErrExtra {
        File fich2 = new File("aux.dat");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(fich2));
            ois = new ObjectInputStream(new FileInputStream(fich));
            while (true) {
                try {
                    Convocatoria conv = (Convocatoria) ois.readObject();

                    if (conv.getConvocatoria().equalsIgnoreCase(convocatoria.getConvocatoria())) {
                        conv.setIdEnunciado(convocatoria.getIdEnunciado());
                    }

                    oos.writeObject(convocatoria);
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            throw new ErrExtra("fichero");
        } finally {
            try {
                ois.close();
                oos.flush();
                oos.close();
                fich.delete();
                fich2.renameTo(fich);
            } catch (IOException ex) {
                throw new ErrExtra("fichero");
            }
        }
    }

    @Override
    public void crearEnunciado(Enunciado enun) throws ErrCrear {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearUnidad(UnidadDidactica uni) throws ErrCrear {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enunciado> listarEnunciados() throws ErrConsultar {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnidadDidactica> listarUnidades() throws ErrConsultar {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarUnidad(int unidad, int enunciado) throws ErrCrear {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
