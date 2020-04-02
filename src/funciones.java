
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vicent
 */
public class funciones {
    public static int pideEntero(String pregunta) {
    while (true) {
        System.out.println(pregunta);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int numero = Integer.parseInt(br.readLine());
            return numero;
        } catch (Exception e) {
            System.out.println("Valor incorrecto.Ha de ser un valor numÃ©rico entero.");
        }
    }
    }
    public static String pregunta(String pregunta) {
    while (true) {
        System.out.println(pregunta);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String respuesta = br.readLine();
            return respuesta;
        } catch (Exception e) {           
        }
    }
    }
    
    public static String fecha_hora(){
                // Crear una instancia de un objeto Date invocando su constructor 
        Date objDate = new Date(); 
 
        // Mostrar la fecha y la hora usando toString ()
        return (objDate.toString());
    }
}
