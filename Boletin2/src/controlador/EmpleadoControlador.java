package controlador;

import modelo.Empleado;
import vista.PanelAlta;
import java.util.GregorianCalendar;

public class EmpleadoControlador {
    public static boolean validarEmpleado(String fechaNacimiento, double sueldo, double sueldoMaximo) {
        try {
            String[] partes = fechaNacimiento.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]) - 1; // Mes en GregorianCalendar va de 0 a 11
            int año = Integer.parseInt(partes[2]);

            GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);
            if (año < 1900 || año > 2015 || sueldo < 0 || sueldo > sueldoMaximo) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
        
        
        
        
        
    }
}
