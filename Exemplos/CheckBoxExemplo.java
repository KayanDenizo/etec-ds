import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxExemplo extends JFrame {
    public CheckBoxExemplo() {
        super("Caixas de Seleção - JCheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 180);
        setLocationRelativeTo(null);
        JCheckBox cbEmail = new JCheckBox("Receber emails");
        JCheckBox cbNotif = new JCheckBox("Ativar notificações");
        JCheckBox cbTermos = new JCheckBox("Aceito os termos");
        JLabel status = new JLabel("Selecione opções");
        ItemListener il = e -> status.setText(String.format("Emails: %s | Notif: %s | Termos: %s",
                cbEmail.isSelected(), cbNotif.isSelected(),
                cbTermos.isSelected()));
        cbEmail.addItemListener(il);
        cbNotif.addItemListener(il);
        cbTermos.addItemListener(il);
        JPanel p = new JPanel(new GridLayout(4, 1));
        p.add(cbEmail);
        p.add(cbNotif);
        p.add(cbTermos);
        p.add(status);
        add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CheckBoxExemplo().setVisible(true));
    }
}