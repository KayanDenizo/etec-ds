package br.com.pi.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JTabbedPane tabbedPane;

    public MainFrame() {
        super("Sistema de Cadastro - Clientes e Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setJMenuBar(createMenuBar());

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Clientes", new ClientePanel());
        tabbedPane.addTab("Produtos", new ProdutoPanel());
        add(tabbedPane, BorderLayout.CENTER);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.addActionListener(e -> {
            int resp = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja sair?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (resp == JOptionPane.YES_OPTION) {
                dispose();
            }
        });
        menuArquivo.add(itemSair);

        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        itemSobre.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Projeto Integrado - Sistema de Cadastro\nJava Swing",
                "Sobre",
                JOptionPane.INFORMATION_MESSAGE
        ));
        menuAjuda.add(itemSobre);

        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);
        return menuBar;
    }
}


