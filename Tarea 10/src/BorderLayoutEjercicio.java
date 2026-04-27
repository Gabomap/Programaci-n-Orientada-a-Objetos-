import java.awt.*;

public class BorderLayoutEjercicio extends Frame {

    public BorderLayoutEjercicio() {
        setTitle("BorderLayout");
        setSize(300, 200);

        setLayout(new BorderLayout());

        add(new Button("NORTE"), BorderLayout.NORTH);
        add(new Button("SUR"), BorderLayout.SOUTH);
        add(new Button("ESTE"), BorderLayout.EAST);
        add(new Button("OESTE"), BorderLayout.WEST);
        add(new Button("CENTRO"), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutEjercicio();
    }
}
