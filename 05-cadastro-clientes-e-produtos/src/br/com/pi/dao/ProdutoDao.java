package br.com.pi.dao;

import br.com.pi.db.ConnectionFactory;
import br.com.pi.model.Produto;

import java.math.BigDecimal;
import java.sql.*;

public class ProdutoDao {
    public long inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, codigo, preco, categoria, tipo, disponivel) VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCodigo());
            BigDecimal preco = produto.getPreco();
            if (preco != null) {
                ps.setBigDecimal(3, preco);
            } else {
                ps.setNull(3, Types.DECIMAL);
            }
            ps.setString(4, produto.getCategoria());
            ps.setString(5, produto.getTipo());
            ps.setBoolean(6, produto.isDisponivel());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
        }
        return -1L;
    }
}


