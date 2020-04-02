
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vicent
 */
public class IncidenciaBDOR {
    
    public static void listaEmpleados() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        ObjectSet result = db.query(Empleado.class);
        while(result.hasNext()) {
            Empleado found = (Empleado) result.next();
            System.out.println(found.toString());
        }
        db.close();
    }
    
    public static void nuevoEmpleado() {
        
       ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
       
       String nusuario = funciones.pregunta("introduce nombre de usuario:");
       String psswd = funciones.pregunta("introduce la contraseña:");
       String ncompleto = funciones.pregunta("introduce el nombre completo: ");
       String tlf = funciones.pregunta("introduce el telefono: ");
       
       Empleado E= new Empleado(nusuario, psswd, ncompleto, tlf);
       db.store(E);
       System.out.println("Empleado guardado " + E);
       db.close();
    }
    
    public static void ValidarEmpleado() {
        
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String FH = sdf.format(new Date());
        int id = TamañoHistorial()+1;
        String N = funciones.pregunta("Escribe el nombre de usuario: ");
        String P = funciones.pregunta("escribre la contraseña: ");
        
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        Empleado E = new Empleado (N, P, null, null);
        ObjectSet result = db.queryByExample(E);

        if (result.hasNext()) {
           Empleado found = (Empleado) result.next();
           System.out.println("Login completado. "); 
           System.out.println("Bienvenido " + found.getNombrecompleto()); 
           Historial H = new Historial(id, found, null, "I", FH);
           db.store(H);
           db.close();
           GestEmp();
        }else {
        System.out.println("usuario o contraseña incorrectos."); 
        db.close(); 
        }
 
    }
    
    public static void GestEmp(){
        int opcion_numero;
        do{                
        System.out.println("¿Que quieres hacer?");
        System.out.println("1- Listado de Empleados.");
        System.out.println("2- Insertar un empleado nuevo en la B.D.");
        System.out.println("3- Validar la entrada de un empleado (suministrando usuario y contraseña),");
        System.out.println("2- Modificar el perfil de un empleado existente..");
        System.out.println("3- Cambiar la contraseña de un empleado existente.");
        System.out.println("4- Eliminar un empleado.");
        System.out.println("5- Manejar incidencias.");
        System.out.println("6- Gestionar el historial.");
        System.out.println("7- salir.");
            
        
        opcion_numero = funciones.pideEntero("introduce un numero");

        switch (opcion_numero) {
                    case 1:
                    IncidenciaBDOR.listaEmpleados();
                    break;
                    /*case 2:                    
                    IncidenciaBDOR.nuevoEmpleado();               
                    break;
                    case 3:                    
                    IncidenciaBDOR.ValidarEmpleado();
                    break;*/
                    case 2:                    
                    IncidenciaBDOR.modificarEmpleado();
                    break;
                    case 3:                    
                    IncidenciaBDOR.cambiarContraseña();
                    break;
                    case 4:
                    IncidenciaBDOR.eliminarEmpleado();
                    break;
                    case 5:
                    IncidenciaBDOR.manejarIncidencias();
                    break;
                    case 6:
                    IncidenciaBDOR.GestionHistorial();    
                    break;                           
                    case 7:
                    System.out.println("Fin del programa.");
                    break;
                    default:
                    System.out.println("valor no valido.");
                }
        }
            while (opcion_numero != 7);
        
    
    }
    
    public static void modificarEmpleado(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        
        Empleado E = new Empleado(funciones.pregunta("Escribe el nombre de usuario del empleado que quieres modificar: "), null, null, null);
        ObjectSet result = db.queryByExample(E);
        while (result.hasNext()) {
            Empleado found = (Empleado) result.next();
            String nCompleto = funciones.pregunta("Escribe de nuevo el nombre completo: ");
            String tlf = funciones.pregunta("escribe de nuevo el telefono del empleado");
            found.setNombrecompleto(nCompleto);
            found.setTelefono(tlf);
            db.store(found);   
            System.out.println("Cambios guardados " + found);       
        }
        db.close();
    }
    
    public static void cambiarContraseña(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        
        String N = funciones.pregunta("Escribe el nombre de usuario: ");
        String P = funciones.pregunta("Escribre la contraseña: ");
        
        Empleado E = new Empleado (N, P, null, null);
        ObjectSet result = db.queryByExample(E);
        if (result.hasNext()) {
           Empleado found = (Empleado) result.next();
           System.out.println("Login completado. "); 
           System.out.println("Bienvenido " + found.getNombrecompleto()); 
           String P2 = funciones.pregunta("Escribe tu nueva contraseña; ");
           found.setPassword(P2);
           db.store(found);
           System.out.println("Cambios guardados " + found); 
        }else {
        System.out.println("usuario o contraseña incorrectos."); 
        } 
        db.close();
    }
    
    public static void eliminarEmpleado(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        
        Empleado E = new Empleado(funciones.pregunta("Escribe el nombre de usuario del empleado que quieres eliminar: "), null, null, null);
        ObjectSet result = db.queryByExample(E);
        if (result.hasNext()) {
            Empleado found = (Empleado) result.next();
            db.delete(found);
            System.out.println("El usuario "+found.getNombrecompleto()+" ha sido eliminado");
        }else{System.out.println("Usuario no encontrado.");
             }
        db.close();
    }
    
    public static void manejarIncidencias() {
        int opcion_numero;
        do{                
        System.out.println("¿Que quieres hacer?");
        System.out.println("1- Obtener un objeto Incidencia a partir de su Id.");
        System.out.println("2- Obtener la lista de todas las incidencias.");
        System.out.println("3- Insertar una incidencia. ");
        System.out.println("4- Obtener las incidencias para un empleado");
        System.out.println("5- Obtener las incidencias creadas por un empleado concreto.");
        System.out.println("6- salir.");          
        
        opcion_numero = funciones.pideEntero("introduce un numero");

        switch (opcion_numero) {
                    case 1:                    
                    ObtenerIncidencia();               
                    break;
                    case 2:                    
                    ListadoIncidencias();
                    break;
                    case 3:                    
                    InsertarIncidencia();
                    break;
                    case 4:                    
                    IncidenciasxEmpleado();
                    break;
                    case 5:
                    IncidenciasDeEmpleado();
                    break;
                    case 6:
                    System.out.println("Fin del programa.");
                    break;
                    default:
                    System.out.println("valor no valido.");
                }
        }
            while (opcion_numero != 6);
    }
    
    private static void ObtenerIncidencia() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        
        Incidencia I = new Incidencia(funciones.pideEntero("Escribe el id de la incidencia que quieres consultar: "), null, null, null, null, null);
        ObjectSet result = db.queryByExample(I);
        if (result.hasNext()) {
            Incidencia found = (Incidencia) result.next();
            System.out.println("Incidencia encontrada: ");
            System.out.println(found.toString());
        }else{
            System.out.println("Incidencia no encontrada.");
        }
        db.close();
    }
    
    private static void ListadoIncidencias() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        ObjectSet result = db.query(Incidencia.class);
        while(result.hasNext()) {
            Incidencia found = (Incidencia) result.next();
            System.out.println(found.toString());
        }
        db.close();
    }

    private static void InsertarIncidencia() {
        //ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        int id = TamañoHistorial()+1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int Id = funciones.pideEntero("introduce el ID de la incidencia: ");
        //String FH = funciones.fecha_hora();
        String FH = sdf.format(new Date());
        Empleado EO = obtenerEmpleadoOrigen();
        Empleado ED = obtenerEmpleadoDestino();
        String Det = funciones.pregunta("Describe la incidencia: ");
        String Tipo = funciones.pregunta("Escribe el tipo de la incidencia (Normal o Urgente): ");

        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        Incidencia I = new Incidencia(Id, FH, EO, ED, Det, Tipo);
        db.store(I);
        if ( I.getTipo()=="urgente" || I.getTipo()=="Urgente" ){
            Historial H = new Historial(id, EO, ED, "U", FH);
            db.store(H);
        }
        
        db.close();
    }

    private static void IncidenciasxEmpleado() {
        int id = TamañoHistorial()+1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String FH = sdf.format(new Date());
        Empleado ED = obtenerEmpleadoDestino();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        Incidencia I = new Incidencia(0, null, null, ED, null, null);
        ObjectSet result = db.queryByExample(I);
        if (result.hasNext()){
            Incidencia found = (Incidencia) result.next();
            System.out.println(found.toString());
            Historial H = new Historial(id, found.getEorigen(), found.getEdestino(), "C", FH);
            db.store(H);
        }else{
            System.out.println("No se han encontrado incidencias para este usuario.");
        }
        db.close();
    }

    private static void IncidenciasDeEmpleado() {
        Empleado EO = obtenerEmpleadoOrigen();
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        Incidencia I = new Incidencia(0, null, EO, null, null, null);
        ObjectSet result = db.queryByExample(I);
        if (result.hasNext()){
            Incidencia found = (Incidencia) result.next();
            System.out.println(found.toString());
        }else{
            System.out.println("No se han encontrado incidencias de este usuario.");
        }
        db.close();
    }
    
    private static Empleado obtenerEmpleadoOrigen(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        Empleado E = new Empleado(funciones.pregunta("Introduce el nombre de usuario del empleado de origen de la incidencia: "), null, null, null);
        ObjectSet result = db.queryByExample(E);
        if (result.hasNext()) {
            Empleado found = (Empleado) result.next();
            E = found;
            db.close();
        }else {
            System.out.println("empleado no encontrado");
        }
        return E;  
    }
    
    private static Empleado obtenerEmpleadoDestino(){
    ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        Empleado E = new Empleado(funciones.pregunta("Introduce el nombre de usuario del empleado de destino de la incidencia: "), null, null, null);
        ObjectSet result = db.queryByExample(E);
        if (result.hasNext()) {
            Empleado found = (Empleado) result.next();
            E = found;
            db.close();
        }else {
            System.out.println("empleado no encontrado");
        }
        return E;  
    }
        
    private static int TamañoHistorial(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        ObjectSet result = db.query(Historial.class);
        int res = result.size();
        db.close();
        return res;
    }
        
    public static void GestionHistorial() {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "incidencias");
        ObjectSet result = db.query(Historial.class);
            while (result.hasNext()) {
            Historial found = (Historial) result.next();
            System.out.println(found.toString());
            }
        db.close();
        }
}
