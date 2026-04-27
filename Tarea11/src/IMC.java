import java.awt.*;
import java.awt.event.*;

public class IMC extends Frame implements ActionListener {

    Label lblPeso, lblAltura, lblResultado;
    TextField txtPeso, txtAltura;
    Button btnCalcular;

    public IMC() {
        setTitle("Calculadora IMC");
        setSize(300, 200);
        setLayout(new FlowLayout());

        lblPeso = new Label("Peso (kg):");
        txtPeso = new TextField(10);

        lblAltura = new Label("Altura (m):");
        txtAltura = new TextField(10);

        btnCalcular = new Button("Calcular IMC");
        lblResultado = new Label("Resultado: ");

        add(lblPeso);
        add(txtPeso);
        add(lblAltura);
        add(txtAltura);
        add(btnCalcular);
        add(lblResultado);

        btnCalcular.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double peso = Double.parseDouble(txtPeso.getText());
            double altura = Double.parseDouble(txtAltura.getText());

            double imc = peso / (altura * altura);

            lblResultado.setText("Resultado: " + imc);
        } catch (Exception ex) {
            lblResultado.setText("Error en datos");
        }
    }

    public static void main(String[] args) {
        new IMC();
    }
}