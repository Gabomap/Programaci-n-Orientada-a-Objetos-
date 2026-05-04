import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ventana2 extends JFrame {
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel etiqueta;
    private JButton boton;
    private JComboBox<String> combo;

    public Ventana2() {
        super("Mi segunda ventana en JavaSwing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout = new GridLayout(2,2);
        getContentPane().setLayout(layout);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        combo = new JComboBox<>();

        ArrayList <String> nombres = new ArrayList<>();
        nombres.add("Gabriel");
        nombres.add("Gregorio");
        nombres.add("Kevin");
        nombres.add("Salazar");
        nombres.add("Mike Tyson");
        ModeloComboNombres modelo = new ModeloComboNombres(nombres);
        combo.setModel(modelo);


        panel1.setBackground(new Color(192, 127, 213));
        panel2.setBackground(new Color(127, 141, 213));
        panel3.setBackground(new Color(251, 112, 128));
        panel4.setBackground(Color.gray);

        etiqueta = new JLabel("Soy un Label");
        boton = new JButton("Soy un boton");
        panel1.add(etiqueta);
        panel2.add(boton);
        panel3.add(combo);

        getContentPane().add(panel1,0);
        getContentPane().add(panel2,1);
        getContentPane().add(panel3,2);
        getContentPane().add(panel4,3);

        setSize(800, 600);
        setVisible(true);
    }
}