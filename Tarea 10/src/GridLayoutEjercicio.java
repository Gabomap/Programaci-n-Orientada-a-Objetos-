import java.awt.*;

public class GridLayoutEjercicio extends Frame {

    public GridLayoutEjercicio() {
        setTitle("GridLayout");
        setSize(300, 200);

        setLayout(new GridLayout(2, 3)); // 2 filas, 3 columnas

        add(new Button("1"));
        add(new Button("2"));
        add(new Button("3"));
        add(new Button("4"));
        add(new Button("5"));
        add(new Button("6"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutEjercicio();
    }
}