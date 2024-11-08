package vista;

import javax.swing.*;
import modelo.Empleado;

public class EmpleadoVista extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem verEmpleados;
    private JMenuItem altaEmpleado;
    private JMenuItem acercaDe;

    private PanelMenuPrincipal panelMenuPrincipal;
    private PanelVer panelVer;
    private PanelAlta panelAlta;
    private PanelInformacion panelInformacion;

    private Empleado empleadoInicial;

    public EmpleadoVista() {
        setTitle("Gestión de Empleados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear empleados precargados
        empleadoInicial = Empleado.generarListaEmpleados();

        // Crear el menú de barra
        menuBar = new JMenuBar();
        menu = new JMenu("Opciones");
        verEmpleados = new JMenuItem("Ver Empleados");
        altaEmpleado = new JMenuItem("Alta Empleado");
        acercaDe = new JMenuItem("Acerca de");

        menu.add(verEmpleados);
        menu.add(altaEmpleado);
        menu.add(acercaDe);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Crear paneles
        panelMenuPrincipal = new PanelMenuPrincipal();
        panelVer = new PanelVer(empleadoInicial, this);
        panelAlta = new PanelAlta(this);
        panelInformacion = new PanelInformacion(this);

        // Mostrar panel de menú principal al inicio
        setContentPane(panelMenuPrincipal);

        // Añadir escuchadores a los botones del panel de menú principal
        panelMenuPrincipal.getBtnVerEmpleados().addActionListener(e -> cambiarPanel(panelVer));
        panelMenuPrincipal.getBtnAltaEmpleado().addActionListener(e -> cambiarPanel(panelAlta));
        panelMenuPrincipal.getBtnAcercaDe().addActionListener(e -> cambiarPanel(panelInformacion));

        // Añadir escuchadores a los elementos de la barra de menú
        verEmpleados.addActionListener(e -> cambiarPanel(panelVer));
        altaEmpleado.addActionListener(e -> cambiarPanel(panelAlta));
        acercaDe.addActionListener(e -> cambiarPanel(panelInformacion));
    }

    public void mostrarMenuPrincipal() {
        cambiarPanel(panelMenuPrincipal);
    }

    private void cambiarPanel(JPanel panel) {
        setContentPane(panel);
        revalidate();
        repaint();
    }

    // Método para añadir un nuevo empleado a la lista enlazada
    public void agregarEmpleado(Empleado nuevoEmpleado) {
        Empleado ultimo = empleadoInicial;
        while (ultimo.getSiguiente() != null) {
            ultimo = ultimo.getSiguiente();
        }
        ultimo.setSiguiente(nuevoEmpleado);
        System.out.println("Empleado agregado: " + nuevoEmpleado.getNombre());
    }

    public Empleado getEmpleadoInicial() {
        return empleadoInicial;
    }
}
