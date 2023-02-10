package archivo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import modelo.TotalRecaudado;

/**
 *
 * @author Sebastian Burgos
 */
public class LeerArchivoTotalAcueducto {

    private ObjectInputStream lectura;
    private String nombreArchivo;

    public LeerArchivoTotalAcueducto() {
        nombreArchivo = "totalDineroRecaudado.bin";
    }

    public LeerArchivoTotalAcueducto(String nombreArchivo) {
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
            System.err.println("Hubo un error estableciendo contacto con el archivo Total Dinero Recaudado." + e.getMessage());
        }

        return false;
    }

    public TotalRecaudado leerArchivo() {
        TotalRecaudado recaudado = null;
        try {
            recaudado = (TotalRecaudado) lectura.readObject();
        } catch (EOFException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo localizar la clase: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Hubo un error al leer el archivo Total Dinero Recaudado." + e.getMessage());
        } finally {
            return recaudado;
        }
    }

    public void cerrarArchivo() {
        try {
            if (lectura != null) {
                lectura.close();
            }
        } catch (IOException e) {
            System.err.println("Hubo un error cerrando el archivo Total Dinero Recaudado." + e.getMessage());
        }
    }
}
