package vista;

import javax.swing.*;
import modelo.Empleado;
import java.awt.*;
import java.text.SimpleDateFormat;

public class PanelVer extends JPanel {
    private JTextField txtNombre, txtFechaNacimiento, txtSueldo, txtSueldoMaximo, txtEdad;
    private JButton btnPrimero, btnAnterior, btnSiguiente, btnUltimo, btnVolverMenu;
    private JLabel lblError;

    private Empleado empleadoActual;
    private EmpleadoVista vista;

    public PanelVer(Empleado empleadoInicial, EmpleadoVista vista) {
        this.empleadoActual = empleadoInicial;
        this.vista = vista;

        setLayout(new BorderLayout());

        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 5, 5)); // Datos en grid
        add(panelDatos, BorderLayout.CENTER);

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Fecha de Nacimiento (dd/MM/yyyy):"));
        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setEditable(false);
        panelDatos.add(txtFechaNacimiento);

        panelDatos.add(new JLabel("Sueldo:"));
        txtSueldo = new JTextField();
        txtSueldo.setEditable(false);
        panelDatos.add(txtSueldo);

        panelDatos.add(new JLabel("Sueldo Máximo:"));
        txtSueldoMaximo = new JTextField();
        txtSueldoMaximo.setEditable(false);
        panelDatos.add(txtSueldoMaximo);
        
        panelDatos.add(new JLabel("Edado:"));
        txtEdad = new JTextField();
        txtEdad.setEditable(false);
        panelDatos.add(txtEdad);

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnPrimero = new JButton("Primero");
        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnUltimo = new JButton("Último");

        panelBotones.add(btnPrimero);
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnUltimo);
        add(panelBotones, BorderLayout.SOUTH); // Añadir panel de botones al sur

        // Botón "Volver al Menú"
        btnVolverMenu = new JButton("Volver al Menú");
        btnVolverMenu.addActionListener(e -> vista.mostrarMenuPrincipal());
        panelBotones.add(btnVolverMenu); // Añadir también al panel de botones

        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        add(lblError, BorderLayout.NORTH); // Colocar el mensaje de error en la parte superior

        mostrarEmpleado(empleadoActual);

        btnPrimero.addActionListener(e -> mostrarEmpleado(empleadoInicial));
        btnUltimo.addActionListener(e -> {
            while (empleadoActual.getSiguiente() != null) {
                empleadoActual = empleadoActual.getSiguiente();
            }
            mostrarEmpleado(empleadoActual);
        });
        btnSiguiente.addActionListener(e -> {
            if (empleadoActual.getSiguiente() != null) {
                empleadoActual = empleadoActual.getSiguiente();
                mostrarEmpleado(empleadoActual);
            }
        });
        btnAnterior.addActionListener(e -> {
            Empleado anterior = empleadoInicial;
            while (anterior != null && anterior.getSiguiente() != empleadoActual) {
                anterior = anterior.getSiguiente();
            }
            if (anterior != null) {
                empleadoActual = anterior;
                mostrarEmpleado(empleadoActual);
            }
        });
    }

    private void mostrarEmpleado(Empleado empleado) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        txtNombre.setText(empleado.getNombre());
        txtFechaNacimiento.setText(formatoFecha.format(empleado.getFechaNacimiento().getTime()));
        txtSueldo.setText(String.valueOf(empleado.getSueldo()));
        txtSueldoMaximo.setText(String.valueOf(empleado.getSueldoMaximo()));
        txtEdad.setText(String.valueOf(empleado.getEdad()));
    }
}
