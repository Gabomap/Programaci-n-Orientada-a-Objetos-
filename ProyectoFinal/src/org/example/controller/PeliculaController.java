package org.example.controller;

import org.example.model.ArchivoPeliculas;
import org.example.model.Pelicula;
import org.example.view.VentanaPeliculas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PeliculaController implements ActionListener {

    private VentanaPeliculas vista;
    private ArrayList<Pelicula> listaPeliculas;
    private ArchivoPeliculas archivo;

    public PeliculaController(VentanaPeliculas vista) {

        this.vista = vista;

        archivo = new ArchivoPeliculas();
        listaPeliculas = archivo.cargar();

        cargarPeliculasEnTabla();

        // BOTONES
        vista.getBtnGuardar().addActionListener(this);
        vista.getBtnModificar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);

        // MENÚ
        vista.getItemGuardarArchivo().addActionListener(this);
        vista.getItemCargarArchivo().addActionListener(this);
        vista.getItemSalir().addActionListener(this);
        vista.getItemColor().addActionListener(this);

        // TABLA
        vista.getTablaPeliculas().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarDatosSeleccionados();
            }
        });

        // RELOJ
        Reloj reloj = new Reloj(vista);
        reloj.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBtnGuardar()) {
            guardar();
        }

        if (e.getSource() == vista.getBtnModificar()) {
            modificar();
        }

        if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }

        if (e.getSource() == vista.getBtnLimpiar()) {
            limpiar();
        }

        if (e.getSource() == vista.getItemGuardarArchivo()) {
            guardarArchivo();
        }

        if (e.getSource() == vista.getItemCargarArchivo()) {
            cargarArchivo();
        }

        if (e.getSource() == vista.getItemColor()) {
            cambiarColor();
        }

        if (e.getSource() == vista.getItemSalir()) {

            archivo.guardar(listaPeliculas);

            JOptionPane.showMessageDialog(
                    vista,
                    "Datos guardados correctamente."
            );

            System.exit(0);
        }
    }

    //Guardar

    private void guardar() {

        try {

            String titulo =
                    vista.getTxtTitulo().getText().trim();

            String director =
                    vista.getTxtDirector().getText().trim();

            if (titulo.isEmpty() || director.isEmpty()) {

                JOptionPane.showMessageDialog(
                        vista,
                        "Título y Director son obligatorios."
                );

                return;
            }

            Pelicula pelicula = new Pelicula(
                    titulo,
                    director,
                    vista.getCmbGenero().getSelectedItem().toString(),
                    Integer.parseInt(vista.getTxtAnio().getText()),
                    Double.parseDouble(vista.getTxtCalificacion().getText()),
                    vista.getTxtComentario().getText(),
                    vista.getChkFavorita().isSelected(),
                    obtenerFormato()
            );

            listaPeliculas.add(pelicula);

            vista.getModeloTabla().addRow(new Object[]{
                    pelicula.getTitulo(),
                    pelicula.getDirector(),
                    pelicula.getGenero(),
                    pelicula.getAnio(),
                    pelicula.getCalificacion(),
                    pelicula.isFavorita(),
                    pelicula.getFormato()
            });

            archivo.guardar(listaPeliculas);

            limpiar();

            JOptionPane.showMessageDialog(
                    vista,
                    "Película guardada correctamente."
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Verifica Año y Calificación."
            );
        }
    }

    //Modificar

    private void modificar() {

        int fila =
                vista.getTablaPeliculas().getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Selecciona una película."
            );

            return;
        }

        try {

            Pelicula pelicula = new Pelicula(
                    vista.getTxtTitulo().getText(),
                    vista.getTxtDirector().getText(),
                    vista.getCmbGenero().getSelectedItem().toString(),
                    Integer.parseInt(vista.getTxtAnio().getText()),
                    Double.parseDouble(vista.getTxtCalificacion().getText()),
                    vista.getTxtComentario().getText(),
                    vista.getChkFavorita().isSelected(),
                    obtenerFormato()
            );

            listaPeliculas.set(fila, pelicula);

            vista.getModeloTabla().setValueAt(
                    pelicula.getTitulo(), fila, 0);

            vista.getModeloTabla().setValueAt(
                    pelicula.getDirector(), fila, 1);

            vista.getModeloTabla().setValueAt(
                    pelicula.getGenero(), fila, 2);

            vista.getModeloTabla().setValueAt(
                    pelicula.getAnio(), fila, 3);

            vista.getModeloTabla().setValueAt(
                    pelicula.getCalificacion(), fila, 4);

            vista.getModeloTabla().setValueAt(
                    pelicula.isFavorita(), fila, 5);

            vista.getModeloTabla().setValueAt(
                    pelicula.getFormato(), fila, 6);

            archivo.guardar(listaPeliculas);

            JOptionPane.showMessageDialog(
                    vista,
                    "Película modificada."
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Error al modificar."
            );
        }
    }

    //Eliminar

    private void eliminar() {

        int fila =
                vista.getTablaPeliculas().getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    vista,
                    "Selecciona una película."
            );

            return;
        }

        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Deseas eliminar la película?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {

            listaPeliculas.remove(fila);
            vista.getModeloTabla().removeRow(fila);

            archivo.guardar(listaPeliculas);
        }
    }

    //Tabla

    private void cargarDatosSeleccionados() {

        int fila =
                vista.getTablaPeliculas().getSelectedRow();

        if (fila == -1) return;

        vista.getTxtTitulo().setText(
                vista.getModeloTabla().getValueAt(fila, 0).toString());

        vista.getTxtDirector().setText(
                vista.getModeloTabla().getValueAt(fila, 1).toString());

        vista.getCmbGenero().setSelectedItem(
                vista.getModeloTabla().getValueAt(fila, 2).toString());

        vista.getTxtAnio().setText(
                vista.getModeloTabla().getValueAt(fila, 3).toString());

        vista.getTxtCalificacion().setText(
                vista.getModeloTabla().getValueAt(fila, 4).toString());

        boolean favorita =
                Boolean.parseBoolean(
                        vista.getModeloTabla().getValueAt(fila, 5).toString());

        vista.getChkFavorita().setSelected(favorita);

        String formato =
                vista.getModeloTabla().getValueAt(fila, 6).toString();

        vista.getRbDVD().setSelected(formato.equals("DVD"));
        vista.getRbBluRay().setSelected(formato.equals("BluRay"));
        vista.getRbStreaming().setSelected(formato.equals("Streaming"));

        Pelicula pelicula = listaPeliculas.get(fila);
        vista.getTxtComentario().setText(
                pelicula.getComentario()
        );
    }

    private void cargarPeliculasEnTabla() {

        vista.getModeloTabla().setRowCount(0);

        for (Pelicula pelicula : listaPeliculas) {

            vista.getModeloTabla().addRow(new Object[]{
                    pelicula.getTitulo(),
                    pelicula.getDirector(),
                    pelicula.getGenero(),
                    pelicula.getAnio(),
                    pelicula.getCalificacion(),
                    pelicula.isFavorita(),
                    pelicula.getFormato()
            });
        }
    }

    //Utilidades

    private String obtenerFormato() {

        if (vista.getRbDVD().isSelected()) return "DVD";

        if (vista.getRbBluRay().isSelected()) return "BluRay";

        if (vista.getRbStreaming().isSelected()) return "Streaming";

        return "";
    }

    private void limpiar() {

        vista.getTxtTitulo().setText("");
        vista.getTxtDirector().setText("");
        vista.getTxtAnio().setText("");
        vista.getTxtCalificacion().setText("");
        vista.getTxtComentario().setText("");

        vista.getCmbGenero().setSelectedIndex(0);

        vista.getChkFavorita().setSelected(false);

        vista.getGrupoFormato().clearSelection();
    }

    //Menu

    private void guardarArchivo() {

        archivo.guardar(listaPeliculas);

        JOptionPane.showMessageDialog(
                vista,
                "Archivo guardado."
        );
    }

    private void cargarArchivo() {

        listaPeliculas = archivo.cargar();

        cargarPeliculasEnTabla();

        JOptionPane.showMessageDialog(
                vista,
                "Archivo cargado."
        );
    }

    private void cambiarColor() {

        Color color =
                JColorChooser.showDialog(
                        vista,
                        "Selecciona un color",
                        Color.WHITE
                );

        if (color != null) {
            vista.getPanelFormulario().setBackground(color);
        }
    }
}