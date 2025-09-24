import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioExemplo extends JFrame {
    private JTextField tfNome, tfEmail, tfIdade;

    public FormularioExemplo() {
        super("Formulário - GridBagLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 240);
        setLocationRelativeTo(null);
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel lbNome = new JLabel("Nome:");
        JLabel lbEmail = new JLabel("Email:");
        JLabel lbIdade = new JLabel("Idade:");
        tfNome = new JTextField(20);
        tfEmail = new JTextField(20);
        tfIdade = new JTextField(5);
        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");
        c.gridx = 0;
        c.gridy = 0;
        form.add(lbNome, c);
        c.gridx = 1;
        c.gridy = 0;
        form.add(tfNome, c);
        c.gridx = 0;
        c.gridy = 1;
        form.add(lbEmail, c);
        c.gridx = 1;
        c.gridy = 1;
        form.add(tfEmail, c);
        c.gridx = 0;
        c.gridy = 2;
        form.add(lbIdade, c);
        c.gridx = 1;
        c.gridy = 2;
        form.add(tfIdade, c);
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botoes.add(btnSalvar);
        botoes.add(btnLimpar);
        add(form, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
        btnSalvar.addActionListener(e -> {
            String msg = String.format("Nome: %s%nEmail: %s%nIdade:%s",
                    tfNome.getText(), tfEmail.getText(),
                    tfIdade.getText());
            JOptionPane.showMessageDialog(this, msg, "Dados salvos",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnLimpar.addActionListener(e -> {
            tfNome.setText("");
            tfEmail.setText("");
            tfIdade.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioExemplo().setVisible(true));
    }
}