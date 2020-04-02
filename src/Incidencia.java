/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicent
 */
public class Incidencia {
    private int idincidencia;
    private String fecha_hora;
    private Empleado Eorigen;
    private Empleado Edestino;
    private String detalle;
    private String tipo;

    public Incidencia() {
    }

    public Incidencia(int idincidencia, String fecha_hora, Empleado Eorigen, Empleado Edestino, String detalle, String tipo) {
        this.idincidencia = idincidencia;
        this.fecha_hora = fecha_hora;
        this.Eorigen = Eorigen;
        this.Edestino = Edestino;
        this.detalle = detalle;
        this.tipo = tipo;
    }

    public int getIdincidencia() {
        return idincidencia;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public Empleado getEorigen() {
        return Eorigen;
    }

    public Empleado getEdestino() {
        return Edestino;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public void setEorigen(Empleado Eorigen) {
        this.Eorigen = Eorigen;
    }

    public void setEdestino(Empleado Edestino) {
        this.Edestino = Edestino;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Incidencia{" + "idincidencia=" + idincidencia + ", fecha_hora=" + fecha_hora + ", Empleado origen=" + Eorigen.getNombrecompleto() + ", Empleado destino=" + Edestino.getNombrecompleto() + ", detalle=" + detalle + ", tipo=" + tipo + '}';
    }
 
}
