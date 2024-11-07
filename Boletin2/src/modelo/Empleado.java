package modelo;

import java.util.GregorianCalendar;

public class Empleado {
    private static int contadorEmpleados = 0;
    private int numeroEmpleado;
    private String nombre;
    private GregorianCalendar fechaNacimiento;
    private double sueldo;
    private double sueldoMaximo;
    private Empleado siguiente; // Apunta al siguiente empleado en la lista enlazada

    // Constructor
    public Empleado(String nombre, GregorianCalendar fechaNacimiento, double sueldo, double sueldoMaximo) {
        this.numeroEmpleado = ++contadorEmpleados;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.sueldoMaximo = sueldoMaximo;
    }

    // Getters y Setters
    public int getNumeroEmpleado() { return numeroEmpleado; }
    public String getNombre() { return nombre; }
    public GregorianCalendar getFechaNacimiento() { return fechaNacimiento; }
    public double getSueldo() { return sueldo; }
    public double getSueldoMaximo() { return sueldoMaximo; }
    public Empleado getSiguiente() { return siguiente; }
    public void setSiguiente(Empleado siguiente) { this.siguiente = siguiente; }

    // Método estático para crear y retornar la lista de empleados precargados
    public static Empleado generarListaEmpleados() {
        Empleado empleado1 = new Empleado("Juan Perez", new GregorianCalendar(1985, 1, 15), 2000, 5000);
        Empleado empleado2 = new Empleado("Ana Lopez", new GregorianCalendar(1990, 4, 25), 2500, 5500);
        Empleado empleado3 = new Empleado("Luis Ramirez", new GregorianCalendar(1982, 8, 10), 2200, 5000);
        Empleado empleado4 = new Empleado("Maria Garcia", new GregorianCalendar(1995, 2, 5), 2100, 5200);
        Empleado empleado5 = new Empleado("Carlos Fernandez", new GregorianCalendar(1979, 11, 30), 2400, 5300);

        // Crear la lista enlazada manualmente
        empleado1.setSiguiente(empleado2);
        empleado2.setSiguiente(empleado3);
        empleado3.setSiguiente(empleado4);
        empleado4.setSiguiente(empleado5);
        
        
        

        return empleado1; // Retorna el primer empleado de la lista
    }
}
