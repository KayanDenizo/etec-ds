import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogosExemplo extends JFrame {
    public DialogosExemplo() {
    super("Caixas de Diálogo - JOptionPane");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(420, 180);
    setLocationRelativeTo(null);
    JButton btnMensagem = new JButton("Mensagem");
    JButton btnConfirm = new JButton("Confirmação");
    JButton btnEntrada = new JButton("Entrada de Texto");
    JButton btnOpcoes = new JButton("Opções");
    btnMensagem.addActionListener(e ->
    JOptionPane.showMessageDialog(this, "Olá, aluno! 👋",
   "Mensagem", JOptionPane.INFORMATION_MESSAGE)
    );
    btnConfirm.addActionListener(e -> {
    int opt = JOptionPane.showConfirmDialog(this, "Deseja continuar?", "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
    JOptionPane.showMessageDialog(this, "Resposta: " + opt);
    });
    btnEntrada.addActionListener(e -> {
    String nome = JOptionPane.showInputDialog(this, "Digite seu nome:");
    JOptionPane.showMessageDialog(this, "Você digitou: " +
   nome);
    });
    btnOpcoes.addActionListener(e -> {
    String[] cursos = {"Java", "Python", "C#", "JavaScript"};
    int idx = JOptionPane.showOptionDialog(this, "Escolha um curso:", "Cursos",
    JOptionPane.DEFAULT_OPTION,
   JOptionPane.QUESTION_MESSAGE, null, cursos, cursos[0]);
    JOptionPane.showMessageDialog(this, "Selecionado: " + (idx
   >= 0 ? cursos[idx] : "nada"));
    });
    JPanel p = new JPanel(new FlowLayout());
    p.add(btnMensagem); p.add(btnConfirm); p.add(btnEntrada);
   p.add(btnOpcoes);
    add(p);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DialogosExemplo().setVisible(true));
    }
}