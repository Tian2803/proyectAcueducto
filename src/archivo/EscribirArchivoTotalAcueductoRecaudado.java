package archivo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import modelo.TotalRecaudado;

/**
 *
 * @author Sebastian Burgos Perez
 */
public class EscribirArchivoTotalAcueductoRecaudado {

    private ObjectOutputStream salida;
    private String nombreArchivo;

    public EscribirArchivoTotalAcueductoRecaudado() {
        nombreArchivo = "totalDineroRecaudado.bin";
    }

    public EscribirArchivoTotalAcueductoRecaudado(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void abrirArchivo() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con el archivo de Total Dinero Recaudado",
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void escribirObjeto(TotalRecaudado recaudado) {
        try {
            salida.flush();
            salida.writeObject(recaudado);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, ("No se pudo agregar al archivo de Total Dinero Recaudado" + e),
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el archivo Total Dinero Recaudado",
                    "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
