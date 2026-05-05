package controlador;

import vista.Ventana5;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador5 implements MouseListener {

    private Ventana5 view;

    public Controlador5(Ventana5 vista) {
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
