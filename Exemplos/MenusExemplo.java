import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class MenusExemplo extends JFrame {
    public MenusExemplo() {
        super("Menus - JMenuBar/JMenu/JMenuItem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 300);
        setLocationRelativeTo(null);
        JMenuBar barra = new JMenuBar();
        JMenu arquivo = new JMenu("Arquivo");
        arquivo.setMnemonic(KeyEvent.VK_A);
        JMenuItem novo = new JMenuItem("Novo");
        novo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        JMenuItem sair = new JMenuItem("Sair");
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        sair.addActionListener(e -> System.exit(0));
        novo.addActionListener(e -> JOptionPane.showMessageDialog(this, "Novo arquivo criado."));
        arquivo.add(novo);
        arquivo.addSeparator();
        arquivo.add(sair);
        JMenu ajuda = new JMenu("Ajuda");
        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener(e -> JOptionPane.showMessageDialog(this, "Exemplo de menus\nSwing Java"));
        ajuda.add(sobre);
        barra.add(arquivo);
        barra.add(ajuda);
        setJMenuBar(barra);
        add(new JLabel("Use os menus acima (Arquivo/Ajuda).",
                SwingConstants.CENTER), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenusExemplo().setVisible(true));
    }
}