package br.com.pi.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.math.BigDecimal;

import br.com.pi.dao.ProdutoDao;
import br.com.pi.model.Produto;
public class ProdutoPanel extends JPanel {
    private JTextField campoNomeProduto;
    private JTextField campoCodigo;
    private JFormattedTextField campoPreco;
    private JComboBox<String> comboCategoria;
    private JCheckBox checkDisponivel;
    private JRadioButton radioConsumivel;
    private JRadioButton radioDuravel;

    public ProdutoPanel() {
        setLayout(new BorderLayout(8, 8));

        JPanel painelFormulario = criarPainelFormulario();
        JPanel painelBotoes = criarPainelBotoes();

        add(painelFormulario, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private JPanel criarPainelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("Dados do Produto"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nome do Produto
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.0;
        panel.add(new JLabel("Nome:"), gbc);
        campoNomeProduto = new JTextField();
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0;
        panel.add(campoNomeProduto, gbc);

        // Código
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.0;
        panel.add(new JLabel("Código:"), gbc);
        campoCodigo = new JTextField();
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 1.0;
        panel.add(campoCodigo, gbc);

        // Preço
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.0;
        panel.add(new JLabel("Preço (R$):"), gbc);
        campoPreco = new JFormattedTextField(java.text.NumberFormat.getNumberInstance());
        campoPreco.setColumns(10);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0;
        panel.add(campoPreco, gbc);

        // Categoria (combo)
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.0;
        panel.add(new JLabel("Categoria:"), gbc);
        comboCategoria = new JComboBox<>(new String[]{
                "Alimentos", "Bebidas", "Higiene", "Limpeza", "Eletrônicos", "Outros"
        });
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 1.0;
        panel.add(comboCategoria, gbc);

        // Tipo (radio)
        gbc.gridx = 0; gbc.gridy = 4; gbc.weightx = 0.0;
        panel.add(new JLabel("Tipo:"), gbc);
        JPanel tipoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        radioConsumivel = new JRadioButton("Consumível");
        radioDuravel = new JRadioButton("Durável");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(radioConsumivel);
        grupoTipo.add(radioDuravel);
        tipoPanel.add(radioConsumivel);
        tipoPanel.add(radioDuravel);
        gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 1.0;
        panel.add(tipoPanel, gbc);

        // Disponível (checkbox)
        gbc.gridx = 0; gbc.gridy = 5; gbc.weightx = 0.0;
        panel.add(new JLabel("Disponível em estoque:"), gbc);
        checkDisponivel = new JCheckBox("Sim");
        gbc.gridx = 1; gbc.gridy = 5; gbc.weightx = 1.0;
        panel.add(checkDisponivel, gbc);

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
        String nome = campoNomeProduto.getText().trim();
        String codigo = campoCodigo.getText().trim();
        String precoTexto = campoPreco.getText().trim();
        String categoria = (String) comboCategoria.getSelectedItem();
        String tipo = radioConsumivel.isSelected() ? "Consumível" : radioDuravel.isSelected() ? "Durável" : "Não informado";
        boolean disponivel = checkDisponivel.isSelected();

        if (nome.isEmpty() || codigo.isEmpty() || precoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Preencha Nome, Código e Preço.",
                    "Validação",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setCodigo(codigo);
        try {
            produto.setPreco(new BigDecimal(precoTexto.replace(".", "").replace(",", ".")));
        } catch (Exception ignore) { /* validado acima, fallback null */ }
        produto.setCategoria(categoria);
        produto.setTipo(tipo);
        produto.setDisponivel(disponivel);

        try {
            long id = new ProdutoDao().inserir(produto);
            StringBuilder resumo = new StringBuilder();
            resumo.append("Produto cadastrado com sucesso!\n\n");
            resumo.append("ID: ").append(id).append('\n');
            resumo.append("Nome: ").append(nome).append('\n');
            resumo.append("Código: ").append(codigo).append('\n');
            resumo.append("Preço (R$): ").append(precoTexto).append('\n');
            resumo.append("Categoria: ").append(categoria).append('\n');
            resumo.append("Tipo: ").append(tipo).append('\n');
            resumo.append("Disponível: ").append(disponivel ? "Sim" : "Não");
            JOptionPane.showMessageDialog(this, resumo.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no banco: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onLimpar() {
        campoNomeProduto.setText("");
        campoCodigo.setText("");
        campoPreco.setValue(null);
        comboCategoria.setSelectedIndex(0);
        checkDisponivel.setSelected(false);
        radioConsumivel.setSelected(false);
        radioDuravel.setSelected(false);
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


