import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotoesExemplo extends JFrame {
    private int contador = 0;

    public BotoesExemplo() {
        super("Botões - JButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 160);
        setLocationRelativeTo(null);
        JLabel lbl = new JLabel("Cliques: 0");
        JButton btnClique = new JButton("Clique-me");
        JButton btnDesabilitar = new JButton("Desabilitar/Habilitar");
        btnClique.addActionListener(e -> lbl.setText("Cliques: " +
                (++contador)));
        btnDesabilitar.addActionListener(e -> btnClique.setEnabled(!btnClique.isEnabled()));
        JPanel p = new JPanel();
        p.add(btnClique);
        p.add(btnDesabilitar);
        p.add(lbl);
        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BotoesExemplo().setVisible(true));
    }
}