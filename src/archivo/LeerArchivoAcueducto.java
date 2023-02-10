package archivo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import modelo.Acueducto;

/**
 *
 * @author Sebastian Burgos
 */
public class LeerArchivoAcueducto {

    private ObjectInputStream lectura;
    private String nombreArchivo;

    public LeerArchivoAcueducto() {
        nombreArchivo = "acueducto.bin";
    }

    public LeerArchivoAcueducto(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public boolean abrirArchivo() {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.exists()) {
                lectura = new ObjectInputStream(new FileInputStream(nombreArchivo));
                return true;
            }
        } catch (IOException e) {
            System.err.println("Hubo un error estableciendo contacto con el archivo Acueducto.");
        }

        return false;
    }

    public ArrayList<Acueducto> leerArchivo() {
        ArrayList<Acueducto> listAcueducto = null;
        try {
            listAcueducto = (ArrayList<Acueducto>) lectura.readObject();
        } catch (EOFException e) {
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo localizar la clase: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Hubo un error al leer el archivo Acueducto.");
        } finally {
            return listAcueducto;
        }
    }

    public void cerrarArchivo() {
        try {
            if (lectura != null) {
                lectura.close();
            }
        } catch (IOException e) {
            System.err.println("Hubo un error cerrando el archivo Acueducto.");
        }
    }
}
