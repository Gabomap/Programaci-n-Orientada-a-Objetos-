package org.example.main;

import javax.swing.SwingUtilities;

import org.example.controller.PeliculaController;
import org.example.view.VentanaPeliculas;

public class Principal {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            VentanaPeliculas vista =
                    new VentanaPeliculas();

            new PeliculaController(vista);
        });
    }
}