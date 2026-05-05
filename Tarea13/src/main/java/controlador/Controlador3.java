package controlador;

import vista.Ventana3;
import vista.VentanaPrincipal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador3 implements MouseListener {

    private Ventana3 view;

    public Controlador3(Ventana3 vista) {
        this.view = vista;
        this.view.getBtnSaludar().addMouseListener(this);
        this.view.getLbNombre().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //this.view.getLblSalida().setText("Hola " + this.view.getTxtNombre().getText());
        if (e.getSource() == this.view.getBtnSaludar()) {
            this.view.getLblSalida().setText("Hola " + this.view.getTxtNombre().getText());
            System.out.println("Halo");
        }

        if (e.getSource() == this.view.getLbNombre()) {
            System.out.println("Desde etiqueta 1");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}