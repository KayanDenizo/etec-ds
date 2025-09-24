import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonsExemplo extends JFrame {
    public RadioButtonsExemplo() {
        super("Botões de Rádio - JRadioButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 180);
        setLocationRelativeTo(null);
        JRadioButton r1 = new JRadioButton("Masculino");
        JRadioButton r2 = new JRadioButton("Feminino");
        JRadioButton r3 = new JRadioButton("Outro");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(r1);
        grupo.add(r2);
        grupo.add(r3);
        JLabel sel = new JLabel("Seleção: (nenhuma)");
        ActionListener al = e -> sel.setText("Seleção: " +
                ((JRadioButton) e.getSource()).getText());
        r1.addActionListener(al);
        r2.addActionListener(al);
        r3.addActionListener(al);
        JPanel p = new JPanel(new GridLayout(4, 1));
        p.add(r1);
        p.add(r2);
        p.add(r3);
        p.add(sel);
        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonsExemplo().setVisible(true));
    }
}