import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleButtonsExemplo extends JFrame {
    public ToggleButtonsExemplo() {
        super("Botões de Seleção - JToggleButton");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 160);
        setLocationRelativeTo(null);
        JToggleButton tg = new JToggleButton("Modo Escuro: OFF");
        JLabel status = new JLabel("Tema atual: Claro");
        tg.addItemListener(e -> {
            boolean ativo = tg.isSelected();
            tg.setText("Modo Escuro: " + (ativo ? "ON" : "OFF"));
            status.setText("Tema atual: " + (ativo ? "Escuro" : "Claro"));
        });
        JPanel p = new JPanel();
        p.add(tg);
        p.add(status);
        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToggleButtonsExemplo().setVisible(true));
    }
}