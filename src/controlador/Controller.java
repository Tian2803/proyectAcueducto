/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import archivo.EscribirArchivoAcueducto;
import archivo.LeerArchivoAcueducto;
import java.util.ArrayList;
import modelo.Acueducto;

/**
 *
 * @author Sebastian Burgos
 */
public class Controller {
    
    private ArrayList<Acueducto> catalogoAcueducto;
    
    public Controller() {
        catalogoAcueducto = new ArrayList();
    }
    
    public ArrayList<Acueducto> getCatalogoAcueducto() {
        return catalogoAcueducto;
    }
    
    public void setCatalogoAcueducto(ArrayList<Acueducto> catalogoAcueducto) {
        this.catalogoAcueducto = catalogoAcueducto;
    }
    
    private void archivo() {
        EscribirArchivoAcueducto escribir = new EscribirArchivoAcueducto();
        escribir.abrirArchivo();
        escribir.escribirObjeto(catalogoAcueducto);
        escribir.cerrarArchivo();
    }
    
    public void registrar(Acueducto suscriptor) {
        this.catalogoAcueducto.add(suscriptor);
        archivo();
    }
    
    private void llenarArryList() {
        LeerArchivoAcueducto leer = new LeerArchivoAcueducto();
        try {
            if (leer.abrirArchivo()) {
                catalogoAcueducto = (ArrayList<Acueducto>) leer.leerArchivo();
                leer.cerrarArchivo();
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo Acueducto.");
        }
    }
    
    public boolean validarSuscriptor(String nombres, String apellidos) {
        llenarArryList();
        for (Acueducto list : catalogoAcueducto) {
            if (list.getNombres().equalsIgnoreCase(nombres) && list.getApellidos().equalsIgnoreCase(apellidos)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean validarCodigo(int codigo) {
        llenarArryList();
        for (Acueducto list : catalogoAcueducto) {
            if (list.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    private int Buscar(int code) {
        llenarArryList();
        for (Acueducto list : catalogoAcueducto) {
            if (list.getCodigo() == code) {
                return catalogoAcueducto.indexOf(list);
            }
        }
        return -1;
    }
    
    public boolean editar(int codigo, Acueducto suscriptor) {
        llenarArryList();
        int pos = Buscar(codigo);
        if (pos != -1) {
            catalogoAcueducto.set(pos, suscriptor);
            archivo();
            return true;
        }
        return false;
    }
    
    public int calcularTotalPagar(int tPresente, int mDeuda, int reconexion, int matricula) {
        return tPresente * mDeuda + reconexion + matricula;
    }
    
    public boolean actualizarFechas(String emision, String oportuno, String suspension, String facturado) {
        llenarArryList();
        boolean bandera = false;
        for (int i = 0; i < catalogoAcueducto.size(); i++) {
            catalogoAcueducto.get(i).setfEmision(emision);
            catalogoAcueducto.get(i).setPagoOportuno(oportuno);
            catalogoAcueducto.get(i).setfSuspension(suspension);
            catalogoAcueducto.get(i).setMesFacturado(facturado);
            catalogoAcueducto.get(i).setMesesDeuda(catalogoAcueducto.get(i).getMesesDeuda() + 1);
            catalogoAcueducto.get(i).setMesesVencidos(catalogoAcueducto.get(i).getMesesDeuda() - 1);
            catalogoAcueducto.get(i).setTotalPagar(catalogoAcueducto.get(i).getTotalPresente() * catalogoAcueducto.get(i).getMesesDeuda()
                    + catalogoAcueducto.get(i).getReconexion() + catalogoAcueducto.get(i).getMatricula());
            bandera = true;
        }
        archivo();
        return bandera;
    }
    
    public Acueducto[] listarSuscriptores() {
        llenarArryList();
        Acueducto[] acue = new Acueducto[this.catalogoAcueducto.size()];
        int indice = 0;
        for (Acueducto list : this.catalogoAcueducto) {
            acue[indice] = list;
            indice++;
        }
        return acue;
    }
    
    public boolean eliminarSuscriptor(int codigo) {
        llenarArryList();
        int pos = Buscar(codigo);
        if (pos != -1) {
            catalogoAcueducto.remove(pos);
            archivo();
            return true;
        }
        return false;
    }
    
    public Acueducto obtenerSuscriptor(int codigo) {
        llenarArryList();
        int pos = Buscar(codigo);
        if (pos != -1) {
            return this.catalogoAcueducto.get(pos);
        }
        return null;
    }
    
    public boolean cobrarDeuda(int codigo, int valorPagar, boolean reconexion, boolean matricula) {
        llenarArryList();
        int pos = Buscar(codigo);
        if (pos != -1) {
            catalogoAcueducto.get(pos).setTotalPagar(catalogoAcueducto.get(pos).getTotalPagar() - valorPagar);
            
            if (catalogoAcueducto.get(pos).getTotalPagar() != 0) {
                catalogoAcueducto.get(pos).setMesesDeuda(catalogoAcueducto.get(pos).getTotalPagar()
                        / catalogoAcueducto.get(pos).getTotalPresente());
                
                catalogoAcueducto.get(pos).setMesesVencidos(catalogoAcueducto.get(pos).getMesesDeuda() - 1);
            } else {
                catalogoAcueducto.get(pos).setMesesDeuda(0);
                catalogoAcueducto.get(pos).setMesesVencidos(-1);
            }
            
            if (reconexion == true) {
                catalogoAcueducto.get(pos).setReconexion(0);
            }
            if (matricula == true) {
                catalogoAcueducto.get(pos).setMatricula(0);
            }
            
            archivo();
            
            return true;
        }
        return false;
    }
    
}
