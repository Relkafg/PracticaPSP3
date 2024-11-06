package vista;

import javax.swing.*;
import modelo.Empleado;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelAlta extends JPanel {
    private JTextField txtNombre, txtFechaNacimiento, txtSueldo, txtSueldoMaximo;
    private JButton btnAceptar, btnCancelar, btnVolverMenu;
    private JLabel lblError;
    private EmpleadoVista vista;

    public PanelAlta(EmpleadoVista vista) {
        this.vista = vista;

        setLayout(new BorderLayout());

        // Panel para los datos del empleado
        JPanel panelDatos = new JPanel(new GridLayout(5, 2, 5, 5));
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

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");
        btnVolverMenu = new JButton("Volver al Menú");

        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);
        panelBotones.add(btnVolverMenu);
        add(panelBotones, BorderLayout.SOUTH); // Añadir panel de botones al sur

        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        add(lblError, BorderLayout.NORTH); // Colocar el mensaje de error en la parte superior

        // Acciones de los botones
        btnAceptar.addActionListener(e -> crearEmpleado());
        btnCancelar.addActionListener(e -> limpiarCampos());
        btnVolverMenu.addActionListener(e -> vista.mostrarMenuPrincipal());
    }

    private void crearEmpleado() {
        // Lógica para crear un nuevo empleado (validaciones y almacenamiento)
        String nombre = txtNombre.getText();
        String fechaNacimientoStr = txtFechaNacimiento.getText();
        String sueldoStr = txtSueldo.getText();
        String sueldoMaximoStr = txtSueldoMaximo.getText();

        // Validar y crear el empleado
        // Aquí deberías agregar tu lógica de validación y creación
        lblError.setText("Empleado creado exitosamente!"); // Mensaje de éxito
        limpiarCampos(); // Limpiar campos después de crear
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtFechaNacimiento.setText("");
        txtSueldo.setText("");
        txtSueldoMaximo.setText("");
        lblError.setText(""); // Limpiar mensaje de error
    }
}
