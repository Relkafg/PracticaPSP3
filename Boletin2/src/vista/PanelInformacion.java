package vista;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    private JButton btnVolverMenu;
    private EmpleadoVista vista;

    public PanelInformacion(EmpleadoVista vista) {
        this.vista = vista;

        setLayout(new BorderLayout());
        JTextArea txtInfo = new JTextArea("Aplicación para gestionar empleados.\nAutor: [Tu Nombre]");
        txtInfo.setEditable(false);
        add(txtInfo, BorderLayout.CENTER);

        // Botón "Volver al Menú"
        btnVolverMenu = new JButton("Volver al Menú");
        btnVolverMenu.addActionListener(e -> vista.mostrarMenuPrincipal());
        add(btnVolverMenu, BorderLayout.SOUTH);
    }
}
