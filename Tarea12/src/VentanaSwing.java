import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaSwing extends JFrame {
    private JLabel etiqueta;
    private JTextField entrada;
    private JButton boton;

    public VentanaSwing() {
        super("Mi primer ventana Swing");
        this.getContentPane().setLayout(new GridLayout(3,3));
        etiqueta = new JLabel("Dame un numero");
        entrada = new JTextField(10);
        boton = new JButton("Enviar");
        boton.setForeground(new Color(104,184,237));
        boton.setBackground(new Color(224,42,42));
        etiqueta.setForeground(new Color(224,42,42));
        boton.setSize(100,100);



        getContentPane().add(etiqueta,0);
        getContentPane().add(entrada,1);
        getContentPane().add(boton,2);
        getContentPane().repaint();
        this.pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                double entradaCelcius = Double.parseDouble(entrada.getText());
                double gradosFahrenheit = (entradaCelcius * 1.8) + 32;
                JOptionPane.showMessageDialog(null,"En Fahrenheit es" + gradosFahrenheit);


            }
        });
        entrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Hola desde el click cuadro de dialogo");
            }

        });
        entrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e){
                System.out.println("Hola desde el keyTyped al cuadro de entrada");
                System.out.println(e.getKeyChar());
                System.out.println(e.getKeyCode());
            }
        });
    }
}
