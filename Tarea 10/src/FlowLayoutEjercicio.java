import java.awt.*;
import java.awt.event.*;

public class FlowLayoutEjercicio extends Frame {

    public FlowLayoutEjercicio() {
        setLayout(new FlowLayout());

        add(new Button("Botón 1"));
        add(new Button("Botón 2"));
        add(new Button("Botón 3"));

        setSize(300, 200);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new FlowLayoutEjercicio();
    }
}