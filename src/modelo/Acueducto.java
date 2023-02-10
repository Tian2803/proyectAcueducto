package modelo;

import java.io.Serializable;

/**
 *
 * @author Sebastian Burgos Perez
 */
public class Acueducto implements Serializable{

    private String nombres;
    private String apellidos;
    private String direccion;
    private int codigo;
    private String fEmision;
    private String pagoOportuno;
    private String fSuspension;
    private String mesFacturado;
    private int mesesVencidos;
    private int mesesDeuda;
    private String consumo;
    private int totalPresente;
    private int reconexion;
    private int matricula;
    private int totalPagar;
    private String alcantarillado;
    private String aseo;
    private String subsidio;
    private String tarifa;

    public Acueducto(String nombres, String apellidos, String direccion, int codigo,
            String fEmision, String pagoOportuno, String fSuspension, String mesFacturado,
            int mesesVencidos, int mesesDeuda, String consumo, int totalPresente,
            int reconexion, int matricula, int totalPagar, String alcantarillado,
            String aseo, String subsidio, String tarifa) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.codigo = codigo;
        this.fEmision = fEmision;
        this.pagoOportuno = pagoOportuno;
        this.fSuspension = fSuspension;
        this.mesFacturado = mesFacturado;
        this.mesesVencidos = mesesVencidos;
        this.mesesDeuda = mesesDeuda;
        this.consumo = consumo;
        this.totalPresente = totalPresente;
        this.reconexion = reconexion;
        this.matricula = matricula;
        this.totalPagar = totalPagar;
        this.alcantarillado = alcantarillado;
        this.aseo = aseo;
        this.subsidio = subsidio;
        this.tarifa = tarifa;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getfEmision() {
        return fEmision;
    }

    public void setfEmision(String fEmision) {
        this.fEmision = fEmision;
    }

    public String getPagoOportuno() {
        return pagoOportuno;
    }

    public void setPagoOportuno(String pagoOportuno) {
        this.pagoOportuno = pagoOportuno;
    }

    public String getfSuspension() {
        return fSuspension;
    }

    public void setfSuspension(String fSuspension) {
        this.fSuspension = fSuspension;
    }

    public String getMesFacturado() {
        return mesFacturado;
    }

    public void setMesFacturado(String mesFacturado) {
        this.mesFacturado = mesFacturado;
    }

    public int getMesesVencidos() {
        return mesesVencidos;
    }

    public void setMesesVencidos(int mesesVencidos) {
        this.mesesVencidos = mesesVencidos;
    }

    public int getMesesDeuda() {
        return mesesDeuda;
    }

    public void setMesesDeuda(int mesesDeuda) {
        this.mesesDeuda = mesesDeuda;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public int getTotalPresente() {
        return totalPresente;
    }

    public void setTotalPresente(int totalPresente) {
        this.totalPresente = totalPresente;
    }

    public int getReconexion() {
        return reconexion;
    }

    public void setReconexion(int reconexion) {
        this.reconexion = reconexion;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getAlcantarillado() {
        return alcantarillado;
    }

    public void setAlcantarillado(String alcantarillado) {
        this.alcantarillado = alcantarillado;
    }

    public String getAseo() {
        return aseo;
    }

    public void setAseo(String aseo) {
        this.aseo = aseo;
    }

    public String getSubsidio() {
        return subsidio;
    }

    public void setSubsidio(String subsidio) {
        this.subsidio = subsidio;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return nombres + apellidos + direccion + codigo + fEmision + pagoOportuno + fSuspension 
                + mesFacturado + mesesVencidos + mesesDeuda + consumo + totalPresente + reconexion
                + matricula + totalPagar + alcantarillado + aseo + subsidio + tarifa;
    }

}
