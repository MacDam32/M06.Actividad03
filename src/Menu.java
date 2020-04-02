
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicent
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion_numero;
        do{                
        System.out.println("¿Que quieres hacer?");
        System.out.println("1- Listado de Empleados.");
        System.out.println("2- Registro para nuevo usuario");
        System.out.println("3- Login Usuario. ");
        /*System.out.println("4- Modificar el perfil de un empleado existente..");
        System.out.println("5- Cambiar la contraseña de un empleado existente.");
        System.out.println("6- Eliminar un empleado.");
        System.out.println("7- Manejar incidencias.");
        System.out.println("8- Gestionar el historial.");*/
        System.out.println("4- salir.");
            
        
        opcion_numero = funciones.pideEntero("introduce un numero");

        switch (opcion_numero) {
                    case 1:
                    IncidenciaBDOR.listaEmpleados();
                    break;
                    case 2:                    
                    IncidenciaBDOR.nuevoEmpleado();               
                    break;
                    case 3:                    
                    IncidenciaBDOR.ValidarEmpleado();
                    break;
                    /*case 4:                    
                    IncidenciaBDOR.modificarEmpleado();
                    break;
                    case 5:                    
                    IncidenciaBDOR.cambiarContraseña();
                    break;
                    case 6:
                    IncidenciaBDOR.eliminarEmpleado();
                    break;
                    case 7:
                    IncidenciaBDOR.manejarIncidencias();
                    break;
                    case 8:
                    IncidenciaBDOR.GestionHistorial();
                    break; */                          
                    case 4:
                    System.out.println("Fin del programa.");
                    break;
                    default:
                    System.out.println("valor no valido.");
                }
        }
            while (opcion_numero != 4);
        
    }
    
}
