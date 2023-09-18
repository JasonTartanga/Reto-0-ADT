/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.Convocatoria;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.InflaterInputStream;
import recursos.MyObjectOutputStream;

/**
 *
 * @author 2dam
 */
public class DAOImplementacionFichero implements DAO {

    File fich = new File("convocatorias.dat");

    @Override
    public void crearConvocatoria(Convocatoria con) {

        ObjectOutputStream oos = null;
        try {
            if (fich.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(fich));
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
                oos.flush();
                oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Convocatoria consultarConvocatoria(String id) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(fich));

            while (true) {
                Convocatoria conv = (Convocatoria) ois.readObject();

                if (conv.getConvocatoria().equalsIgnoreCase(id)) {
                    ois.close();
                    return conv;
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(DAOImplementacionFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
