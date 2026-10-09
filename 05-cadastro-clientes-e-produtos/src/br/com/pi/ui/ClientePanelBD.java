package br.com.pi.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import br.com.pi.dao.ClienteDao;
import br.com.pi.model.Cliente;

public class ClientePanelBD extends JPanel {
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoCpf;
    private JCheckBox checkNewsletter;
    private JRadioButton radioMasc;
    private JRadioButton radioFem;
    private JRadioButton radioOutro;
    private JComboBox<String> comboUf;

    public ClientePanelBD() {
        setLayout(new BorderLayout(8, 8));

        JPanel painelFormulario = criarPainelFormulario();
        JPanel painelBotoes = criarPainelBotoes();

        add(painelFormulario, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private JPanel criarPainelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Dados do Cliente"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nome
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.0;
        panel.add(new JLabel("Nome:"), gbc);
        campoNome = new JTextField();
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
        panel.add(campoNome, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0;
        panel.add(new JLabel("Email:"), gbc);
        campoEmail = new JTextField();
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0;
        panel.add(campoEmail, gbc);

        // CPF
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.0;
        panel.add(new JLabel("CPF:"), gbc);
        campoCpf = new JTextField();
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0;
        panel.add(campoCpf, gbc);

        // Sexo (radio buttons)
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.0;
        panel.add(new JLabel("Sexo:"), gbc);
        JPanel sexoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        radioMasc = new JRadioButton("Masculino");
        radioFem = new JRadioButton("Feminino");
        radioOutro = new JRadioButton("Outro");
        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(radioMasc);
        grupoSexo.add(radioFem);
        grupoSexo.add(radioOutro);
        sexoPanel.add(radioMasc);
        sexoPanel.add(radioFem);
        sexoPanel.add(radioOutro);
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0;
        panel.add(sexoPanel, gbc);

        // UF (combo box)
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.0;
        panel.add(new JLabel("UF:"), gbc);
        comboUf = new JComboBox<>(new String[]{
                "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA",
                "MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN",
                "RS","RO","RR","SC","SP","SE","TO"
        });
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 1.0;
        panel.add(comboUf, gbc);

        // Newsletter (checkbox)
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0.0;
        panel.add(new JLabel("Receber newsletter:"), gbc);
        checkNewsletter = new JCheckBox("Sim");
        gbc.gridx = 1; gbc.gridy = 5; gbc.weightx = 1.0;
        panel.add(checkNewsletter, gbc);

        return panel;
    }

    private JPanel criarPainelBotoes() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");

        btnCadastrar.addActionListener(e -> onCadastrar());
        btnLimpar.addActionListener(e -> onLimpar());
        btnSair.addActionListener(e -> onSair());

        panel.add(btnCadastrar);
        panel.add(btnLimpar);
        panel.add(btnSair);
        return panel;
    }

    private void onCadastrar() {
        String nome = campoNome.getText().trim();
        String email = campoEmail.getText().trim();
        String cpf = campoCpf.getText().trim();
        String sexo = radioMasc.isSelected() ? "Masculino" : radioFem.isSelected() ? "Feminino" : radioOutro.isSelected() ? "Outro" : "Não informado";
        String uf = (String) comboUf.getSelectedItem();
        boolean newsletter = checkNewsletter.isSelected();

        if (nome.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Preencha Nome, Email e CPF.",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCpf(cpf);
        cliente.setSexo(sexo);
        cliente.setUf(uf);
        cliente.setNewsletter(newsletter);

        try {
            long id = new ClienteDao().inserir(cliente);
            StringBuilder resumo = new StringBuilder();
            resumo.append("Cliente cadastrado com sucesso!\n\n");
            resumo.append("ID: ").append(id).append('\n');
            resumo.append("Nome: ").append(nome).append('\n');
            resumo.append("Email: ").append(email).append('\n');
            resumo.append("CPF: ").append(cpf).append('\n');
            resumo.append("Sexo: ").append(sexo).append('\n');
            resumo.append("UF: ").append(uf).append('\n');
            resumo.append("Newsletter: ").append(newsletter ? "Sim" : "Não");
            JOptionPane.showMessageDialog(this, resumo.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onLimpar() {
        campoNome.setText("");
        campoEmail.setText("");
        campoCpf.setText("");
        checkNewsletter.setSelected(false);
        radioMasc.setSelected(false);
        radioFem.setSelected(false);
        radioOutro.setSelected(false);
        comboUf.setSelectedIndex(0);
    }

    private void onSair() {
        int resp = JOptionPane.showConfirmDialog(
                this,
                "Deseja sair da aplicação?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (resp == JOptionPane.YES_OPTION) {
            Window window = SwingUtilities.getWindowAncestor(this);
            if (window != null) {
                window.dispose();
            }
        }
    }
}

