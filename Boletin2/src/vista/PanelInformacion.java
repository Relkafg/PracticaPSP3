package vista;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    private JButton btnVolverMenu;
    private EmpleadoVista vista;

    public PanelInformacion(EmpleadoVista vista) {
        this.vista = vista;

        setLayout(new BorderLayout());
        // Autores del código
        JTextArea txtInfo = new JTextArea("Aplicación para gestionar empleados.\nAutores: \nIván Batista Herrero \nDaniel Fernández Guzmán");
        txtInfo.setEditable(false);
        
        // Establecemos un margen para que el texto no salga totalmente pegado a la izquierda
        txtInfo.setMargin(new Insets(10, 10, 10, 10));
        // Añadimos el texto al BorderLayout
        add(txtInfo, BorderLayout.CENTER);

     /* *******************************  Botón "Volver al Menú"  ******************************* */
        btnVolverMenu = new JButton("Volver al Menú");
        btnVolverMenu.addActionListener(e -> vista.mostrarMenuPrincipal());
        
        // Envolvemos el botón en un panel con FlowLayout para respetar el tamaño que queremos
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(btnVolverMenu);
        // Agregamos el panel en el que esta envuelto el botón
        add(panelBoton, BorderLayout.SOUTH);
    }
}
