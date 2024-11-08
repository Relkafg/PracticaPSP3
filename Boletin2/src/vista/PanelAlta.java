package vista;

import modelo.Empleado;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.text.ParseException;

public class PanelAlta extends JPanel {
    private JTextField txtNombre, txtFechaNacimiento, txtSueldo, txtSueldoMaximo, txtEdad;
    private JButton btnAceptar, btnCancelar, btnVolverMenu;
    private JLabel lblError;
    private EmpleadoVista vista;

    public PanelAlta(EmpleadoVista vista) {
        this.vista = vista;

        setLayout(new BorderLayout());

        // Panel para los datos del empleado
        JPanel panelDatos = new JPanel(new GridLayout(6, 2, 5, 5));
        add(panelDatos, BorderLayout.CENTER);

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Fecha de Nacimiento (dd/MM/yyyy):"));
        txtFechaNacimiento = new JTextField();
        panelDatos.add(txtFechaNacimiento);

        panelDatos.add(new JLabel("Sueldo:"));
        txtSueldo = new JTextField();
        panelDatos.add(txtSueldo);

        panelDatos.add(new JLabel("Sueldo Máximo:"));
        txtSueldoMaximo = new JTextField();
        panelDatos.add(txtSueldoMaximo);
        
        panelDatos.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelDatos.add(txtEdad);

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnVolverMenu = new JButton("Volver al Menú");

        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnVolverMenu);
        add(panelBotones, BorderLayout.SOUTH);

        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        add(lblError, BorderLayout.NORTH);

        // Acciones de los botones
        btnAceptar.addActionListener(e -> crearEmpleado());
        btnCancelar.addActionListener(e -> limpiarCampos());
        btnVolverMenu.addActionListener(e -> vista.mostrarMenuPrincipal());
    }

    private void crearEmpleado() {
        String nombre = txtNombre.getText().trim();
        String fechaNacimientoStr = txtFechaNacimiento.getText().trim();
        String sueldoStr = txtSueldo.getText().trim();
        String sueldoMaximoStr = txtSueldoMaximo.getText().trim();
        String edadStr = txtEdad.getText().trim();

        if (nombre.isEmpty() || fechaNacimientoStr.isEmpty() || sueldoStr.isEmpty() || sueldoMaximoStr.isEmpty() || edadStr.isEmpty()) {
            lblError.setText("Todos los campos son obligatorios.");
            return;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            GregorianCalendar fechaNacimiento = new GregorianCalendar();
            fechaNacimiento.setTime(sdf.parse(fechaNacimientoStr));

            double sueldo = Double.parseDouble(sueldoStr);
            double sueldoMaximo = Double.parseDouble(sueldoMaximoStr);
            int edad = Integer.parseInt(edadStr);

            Empleado nuevoEmpleado = new Empleado(nombre, fechaNacimiento, sueldo, sueldoMaximo, edad);
            vista.agregarEmpleado(nuevoEmpleado);

            lblError.setText("Empleado creado exitosamente!");
            limpiarCampos();

        } catch (ParseException e) {
            lblError.setText("Formato de fecha incorrecto. Use dd/MM/yyyy.");
        } catch (NumberFormatException e) {
            lblError.setText("Sueldo y sueldo máximo deben ser números.");
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtFechaNacimiento.setText("");
        txtSueldo.setText("");
        txtSueldoMaximo.setText("");
        txtEdad.setText("");
        lblError.setText("");
    }
}
