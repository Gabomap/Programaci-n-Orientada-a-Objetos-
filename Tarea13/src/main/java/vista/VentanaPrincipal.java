package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JLabel lbNombre;
    private JTextField txtNombre;
    private JButton btnSaludar;
    private JLabel lblSalida;


    public VentanaPrincipal() {
        super("Tarea13");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        panel1 = new JPanel();
        panel1.setBackground(new Color(95, 252, 98));
        panel2 = new JPanel();
        panel2.setBackground(new Color(246, 184, 25, 255));

        lbNombre = new JLabel("Dame Tu Nombre:");
        txtNombre = new JTextField(20);
        btnSaludar = new JButton("Saludar");
        lblSalida = new JLabel("...");

        panel1.add(lbNombre);
        panel1.add(txtNombre);
        panel1.add(btnSaludar);
        panel1.add(lblSalida);

        this.getContentPane().add(panel1, 0 );
        this.getContentPane().add(panel2, 1 );

        setSize(800, 600);
        setVisible(true);

    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JLabel getLbNombre() {
        return lbNombre;
    }

    public void setLbNombre(JLabel lbNombre) {
        this.lbNombre = lbNombre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JButton getBtnSaludar() {
        return btnSaludar;
    }

    public void setBtnSaludar(JButton btnSaludar) {
        this.btnSaludar = btnSaludar;
    }

    public JLabel getLblSalida() {
        return lblSalida;
    }

    public void setLblSalida(JLabel lblSalida) {
        this.lblSalida = lblSalida;
    }
}
