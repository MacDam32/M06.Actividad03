/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicent
 */
public class Historial {
    
    private Integer idevento;
    private Empleado empleadoO;
    private Empleado empleadoD;
    private String tipo;
    private String fechahora;
    
    public Historial() {
    }

    public Historial(Integer idevento, Empleado empleadoO, Empleado empleadoD, String tipo, String fechahora) {
        this.idevento = idevento;
        this.empleadoO = empleadoO;
        this.empleadoD = empleadoD;
        this.tipo = tipo;
        this.fechahora = fechahora;
    }

    public Integer getIdevento() {
        return idevento;
    }
    
    public Empleado getEmpleadoO() {
        return empleadoO;
    }

    public Empleado getEmpleadoD() {
        return empleadoD;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public void setEmpleadoO(Empleado empleadoO) {
        this.empleadoO = empleadoO;
    }

    public void setEmpleadoD(Empleado empleadoD) {
        this.empleadoD = empleadoD;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    /*@Override
    public String toString() {
        return "Historial{ id de evento = "+ idevento + "empleado origen=" + empleadoO + "empleado destino=" + empleadoD+ ", tipo=" + tipo + ", fechahora=" + fechahora + '}';
    }*/

    @Override
    public String toString() {
        return "Historial{" + "idevento=" + idevento + ", empleadoO=" + empleadoO + ", empleadoD=" + empleadoD + ", tipo=" + tipo + ", fechahora=" + fechahora + '}';
    }
    
    
}
