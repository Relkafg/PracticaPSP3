package vista;

import javax.swing.*;
import java.awt.*;

public class PanelMenuPrincipal extends JPanel {
    private JButton btnVerEmpleados;
    private JButton btnAltaEmpleado;
    private JButton btnAcercaDe;

    public PanelMenuPrincipal() {
        setLayout(new GridLayout(3, 1));

        btnVerEmpleados = new JButton("Ver Empleados");
        btnAltaEmpleado = new JButton("Alta Empleado");
        btnAcercaDe = new JButton("Acerca de");

        add(btnVerEmpleados);
        add(btnAltaEmpleado);
        add(btnAcercaDe);
    }

    public JButton getBtnVerEmpleados() {
        return btnVerEmpleados;
    }

    public JButton getBtnAltaEmpleado() {
        return btnAltaEmpleado;
    }

    public JButton getBtnAcercaDe() {
        return btnAcercaDe;
    }
}
