package vista;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    private JButton btnVolverMenu;
    private EmpleadoVista vista;

    public PanelInformacion(EmpleadoVista vista) {
        this.vista = vista;

        setLayout(new BorderLayout());
        JTextArea txtInfo = new JTextArea("Aplicación para gestionar empleados.\nAutores: \nIván Batista Herrero \n Daniel Fernández Guzman");
        txtInfo.setEditable(false);
        
        txtInfo.setMargin(new Insets(10, 10, 10, 10));
        
        add(txtInfo, BorderLayout.CENTER);

        // Botón "Volver al Menú"
        btnVolverMenu = new JButton("Volver al Menú");
        btnVolverMenu.addActionListener(e -> vista.mostrarMenuPrincipal());
        add(btnVolverMenu, BorderLayout.SOUTH);
    }
}
