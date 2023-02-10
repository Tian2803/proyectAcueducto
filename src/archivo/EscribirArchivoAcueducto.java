package archivo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Acueducto;

/**
 *
 * @author Sebastian Burgos Perez
 */
public class EscribirArchivoAcueducto {

    private ObjectOutputStream salida;
    private String nombreArchivo;

    public EscribirArchivoAcueducto() {
        nombreArchivo = "acueducto.bin";
    }

    public EscribirArchivoAcueducto(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void abrirArchivo() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con el archivo de Acueducto",
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void escribirObjeto(ArrayList<Acueducto> listAcueducto) {
        try {
            salida.flush();
            salida.writeObject(listAcueducto);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, ("No se pudo agregar al archivo de Acueducto" + e),
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el archivo Acueducto",
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
