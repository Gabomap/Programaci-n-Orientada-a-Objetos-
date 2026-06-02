package org.example.controller;

import org.example.view.VentanaPeliculas;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reloj extends Thread {

    private VentanaPeliculas vista;
    private boolean ejecutando = true;

    public Reloj(VentanaPeliculas vista) {
        this.vista = vista;
    }

    public void detener() {
        ejecutando = false;
    }

    @Override
    public void run() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        while (ejecutando) {

            String hora =
                    LocalTime.now().format(formato);

            SwingUtilities.invokeLater(() ->
                    vista.getLblReloj().setText("Hora: " + hora)
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}