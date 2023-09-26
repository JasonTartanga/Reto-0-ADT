/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.ErrConsultar;
import excepciones.ErrCrear;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import recursos.MyObjectOutputStream;

/**
 *
 * @author 2dam
 */
public class ImplementacionFich implements DAO {

    File fich = new File("convocatorias.dat");

    public void crearConvocatoria(Convocatoria con) {
        ObjectOutputStream oos = null;

        try {
            if (fich.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(fich, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(fich));
            }

            oos.writeObject(con);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Convocatoria consultarConvocatoria(String id) {
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
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return convocatoria;
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
    public List<Convocatoria> listarConvocatorias() throws ErrConsultar {
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
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(ImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return convocatorias;
    }

    @Override
    public List<UnidadDidactica> listarUnidades() throws ErrConsultar {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarUnidad(int unidad, int enunciado) throws ErrCrear {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarEnunciado(int enunciado, int convocatoria) throws ErrCrear {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
