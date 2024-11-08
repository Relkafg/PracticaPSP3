package vista;

import javax.swing.*;
import java.awt.*;

public class PanelMenuPrincipal extends JPanel {
    private JButton btnVerEmpleados;
    private JButton btnAltaEmpleado;
    private JButton btnAcercaDe;

    public PanelMenuPrincipal() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new  GridBagConstraints();

        btnVerEmpleados = new JButton("Ver Empleados");
        btnAltaEmpleado = new JButton("Alta Empleado");
        btnAcercaDe = new JButton("Acerca de");
        
     /* ************************ Establece un tamaño predeterminado de los botones *********************** */
        
        Dimension buttonSize = new Dimension(150, 50);
        btnVerEmpleados.setPreferredSize(buttonSize);
        btnAltaEmpleado.setPreferredSize(buttonSize);
        btnAcercaDe.setPreferredSize(buttonSize);
        
        
     /* ************************ Configuración de restricciones para el GridBagLayout *********************** */
        
        gbc.fill = GridBagConstraints.NONE; // Evita que los botones se expandan
        gbc.anchor = GridBagConstraints.CENTER; // Centra los botones
        gbc.gridx = 0; // Establece los botones en una columna única

        
     /* ******************* Añadimos margnes en Top y en Bottom de cada botón para que no se vena pegados unos a otros ******************* */
        gbc.insets = new Insets(10, 0, 10, 0); 
        
        
     /* ************  Añadimos los botones y con el atributo "gridy" asignamos la fila del layout donde se añadirá cada botón ************ */
        
        gbc.gridy = 0;
        add(btnVerEmpleados, gbc);

        gbc.gridy = 1; 
        add(btnAltaEmpleado, gbc);

        gbc.gridy = 2; 
        add(btnAcercaDe, gbc);
    }

    /* ********************************  Métodos getter  ******************************** */
    
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
