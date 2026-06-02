package org.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPeliculas extends JFrame {

    // Paneles
    private JPanel panelFormulario;
    private JPanel panelTabla;

    // Labels
    private JLabel lblTitulo;
    private JLabel lblDirector;
    private JLabel lblAnio;
    private JLabel lblCalificacion;
    private JLabel lblGenero;
    private JLabel lblComentario;
    private JLabel lblFormato;
    private JLabel lblReloj;

    // TextFields
    private JTextField txtTitulo;
    private JTextField txtDirector;
    private JTextField txtAnio;
    private JTextField txtCalificacion;

    // TextArea
    private JTextArea txtComentario;

    // ComboBox
    private JComboBox<String> cmbGenero;

    // CheckBox
    private JCheckBox chkFavorita;

    // RadioButtons
    private JRadioButton rbDVD;
    private JRadioButton rbBluRay;
    private JRadioButton rbStreaming;
    private ButtonGroup grupoFormato;

    // Botones
    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JButton btnBuscar;

    // Tabla
    private JTable tablaPeliculas;
    private DefaultTableModel modeloTabla;

    // Menú
    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenu menuOpciones;

    private JMenuItem itemGuardarArchivo;
    private JMenuItem itemCargarArchivo;
    private JMenuItem itemSalir;
    private JMenuItem itemColor;

    // Choosers
    private JFileChooser fileChooser;
    private JColorChooser colorChooser;

    public VentanaPeliculas() {

        super("Sistema de Gestión de Películas");

        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2, 1));

        panelFormulario = new JPanel();
        panelTabla = new JPanel();

        panelFormulario.setBackground(new Color(1, 241, 173, 255));

        add(panelFormulario);
        add(panelTabla);

        // Labels
        lblTitulo = new JLabel("Título:");
        lblDirector = new JLabel("Director:");
        lblAnio = new JLabel("Año:");
        lblCalificacion = new JLabel("Calificación:");
        lblGenero = new JLabel("Género:");
        lblComentario = new JLabel("Comentario:");
        lblFormato = new JLabel("Formato:");
        lblReloj = new JLabel("00:00:00");

        // TextFields
        txtTitulo = new JTextField(15);
        txtDirector = new JTextField(15);
        txtAnio = new JTextField(5);
        txtCalificacion = new JTextField(5);

        // TextArea
        txtComentario = new JTextArea(4, 20);
        JScrollPane scrollComentario =
                new JScrollPane(txtComentario);

        // ComboBox
        cmbGenero = new JComboBox<>();

        cmbGenero.addItem("Acción");
        cmbGenero.addItem("Drama");
        cmbGenero.addItem("Comedia");
        cmbGenero.addItem("Terror");
        cmbGenero.addItem("Animación");
        cmbGenero.addItem("Ciencia Ficción");

        // CheckBox
        chkFavorita = new JCheckBox("Favorita");

        // RadioButtons
        rbDVD = new JRadioButton("DVD");
        rbBluRay = new JRadioButton("BluRay");
        rbStreaming = new JRadioButton("Streaming");

        grupoFormato = new ButtonGroup();

        grupoFormato.add(rbDVD);
        grupoFormato.add(rbBluRay);
        grupoFormato.add(rbStreaming);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");
        btnBuscar = new JButton("Buscar");

        // Formulario
        panelFormulario.add(lblTitulo);
        panelFormulario.add(txtTitulo);

        panelFormulario.add(lblDirector);
        panelFormulario.add(txtDirector);

        panelFormulario.add(lblAnio);
        panelFormulario.add(txtAnio);

        panelFormulario.add(lblCalificacion);
        panelFormulario.add(txtCalificacion);

        panelFormulario.add(lblGenero);
        panelFormulario.add(cmbGenero);

        panelFormulario.add(chkFavorita);

        panelFormulario.add(lblFormato);
        panelFormulario.add(rbDVD);
        panelFormulario.add(rbBluRay);
        panelFormulario.add(rbStreaming);

        panelFormulario.add(lblComentario);
        panelFormulario.add(scrollComentario);

        panelFormulario.add(lblReloj);

        panelFormulario.add(btnGuardar);
        panelFormulario.add(btnModificar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnLimpiar);
        panelFormulario.add(btnBuscar);

        // Tabla
        String[] columnas = {
                "Título",
                "Director",
                "Género",
                "Año",
                "Calificación",
                "Favorita",
                "Formato"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaPeliculas = new JTable(modeloTabla);

        JScrollPane scrollTabla =
                new JScrollPane(tablaPeliculas);

        scrollTabla.setPreferredSize(
                new Dimension(1000, 250));

        panelTabla.add(scrollTabla);

        // Menú
        menuBar = new JMenuBar();

        menuArchivo = new JMenu("Archivo");
        menuOpciones = new JMenu("Opciones");

        itemGuardarArchivo =
                new JMenuItem("Guardar Archivo");

        itemCargarArchivo =
                new JMenuItem("Cargar Archivo");

        itemSalir =
                new JMenuItem("Salir");

        itemColor =
                new JMenuItem("Cambiar Color");

        menuArchivo.add(itemGuardarArchivo);
        menuArchivo.add(itemCargarArchivo);
        menuArchivo.add(itemSalir);

        menuOpciones.add(itemColor);

        menuBar.add(menuArchivo);
        menuBar.add(menuOpciones);

        setJMenuBar(menuBar);

        // Choosers
        fileChooser = new JFileChooser();
        colorChooser = new JColorChooser();

        setVisible(true);
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public JTextField getTxtDirector() {
        return txtDirector;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public JTextField getTxtCalificacion() {
        return txtCalificacion;
    }

    public JTextArea getTxtComentario() {
        return txtComentario;
    }

    public JComboBox<String> getCmbGenero() {
        return cmbGenero;
    }

    public JCheckBox getChkFavorita() {
        return chkFavorita;
    }

    public JRadioButton getRbDVD() {
        return rbDVD;
    }

    public JRadioButton getRbBluRay() {
        return rbBluRay;
    }

    public JRadioButton getRbStreaming() {
        return rbStreaming;
    }

    public ButtonGroup getGrupoFormato() {
        return grupoFormato;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTable getTablaPeliculas() {
        return tablaPeliculas;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public JLabel getLblReloj() {
        return lblReloj;
    }

    public JMenuItem getItemGuardarArchivo() {
        return itemGuardarArchivo;
    }

    public JMenuItem getItemCargarArchivo() {
        return itemCargarArchivo;
    }

    public JMenuItem getItemSalir() {
        return itemSalir;
    }

    public JMenuItem getItemColor() {
        return itemColor;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public JColorChooser getColorChooser() {
        return colorChooser;
    }

    public JPanel getPanelFormulario() {
        return panelFormulario;
    }
}