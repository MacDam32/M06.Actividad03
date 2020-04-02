/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicent
 */
public class Empleado {
    
    private String nombreusuario;
    private String password;
    private String nombrecompleto;
    private String telefono;

    public Empleado() {
    }

    public Empleado(String nombreusuario, String password, String nombrecompleto, String telefono) {
        this.nombreusuario = nombreusuario;
        this.password = password;
        this.nombrecompleto = nombrecompleto;
        this.telefono = telefono;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombreusuario=" + nombreusuario + ", password=" + password + ", nombrecompleto=" + nombrecompleto + ", telefono=" + telefono + '}';
    }
    
    
}
