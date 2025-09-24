import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
public class CampoTextoExemplo extends JFrame {
 public CampoTextoExemplo() {
 super("Campo de Texto - JTextField");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setSize(420, 160);
 setLocationRelativeTo(null);
 JTextField tf = new JTextField(25);
 JLabel contador = new JLabel("0 caracteres");
 tf.getDocument().addDocumentListener(new DocumentListener() {
 private void update() {
contador.setText(tf.getText().length() + " caracteres"); }
 public void insertUpdate(DocumentEvent e) { update(); }
 public void removeUpdate(DocumentEvent e) { update(); }
 public void changedUpdate(DocumentEvent e) { update(); }
 });
 JPanel p = new JPanel();
 p.add(new JLabel("Digite algo:"));
 p.add(tf);
 p.add(contador);
 add(p);
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(() -> new
CampoTextoExemplo().setVisible(true));
 }
}