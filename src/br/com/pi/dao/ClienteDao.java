package br.com.pi.dao;

import br.com.pi.db.ConnectionFactory;
import br.com.pi.model.Cliente;

import java.sql.*;

public class ClienteDao {
    public long inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, email, cpf, sexo, uf, newsletter) VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getUf());
            ps.setBoolean(6, cliente.isNewsletter());
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


