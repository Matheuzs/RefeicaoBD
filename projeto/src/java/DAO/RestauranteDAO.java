package DAO;

import Conexao.Conexao;
import Modelo.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {

    public void inserir(Restaurante restaurante) {
        String query = "INSERT INTO restaurante(cnpj,nome_oficial,nome_fantasia,endereco,telefone,email) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, restaurante.getCNPJ().toString());
            statement.setString(2, restaurante.getNomeOficial());
            statement.setString(3, "" + restaurante.getNomeFantasia());
            statement.setString(4, "" + restaurante.getEndereco());
            statement.setString(5, "" + restaurante.getTelefone());
            statement.setString(6, "" + restaurante.getEmail());
            statement.execute();
            statement.close();
            System.out.println("Registro adicionado em restaurante! (^_^)");
        } catch (SQLException ex) {
            System.out.println("Erro na inclusao de registro em restaurante! ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em restauranteDAO! ( -_-)\n" + ex);
            }
        }
    }

    public void excluir(Restaurante restaurante) {
        String query = "DELETE FROM restaurante WHERE CNPJ = ?";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        int result = 0;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, restaurante.getCNPJ());
            result = statement.executeUpdate();
            statement.close();
            if (result != 0) {
                System.out.println("Registro removido em restaurante! (^_^)");
            } else {
                System.out.println("Registro não encontradO em restaurante! (-_- )");
            }
        } catch (SQLException ex) {
            System.out.println("Erro na exclusao de registro em restaurante! ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em restauranteDAO! ( -_-)\n" + ex);
            }
        }
    }

    public void atualizar(Restaurante restaurante) {
        String query = "UPDATE restaurante SET nome_oficial = ?,nome_fantasia = ?, endereco = ?, telefone = ?, email = ? WHERE CNPJ = ?";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        int result = 0;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, restaurante.getNomeOficial());
            statement.setString(2, "" + restaurante.getNomeFantasia());
            statement.setString(3, "" + restaurante.getEndereco());
            statement.setString(4, "" + restaurante.getTelefone());
            statement.setString(5, restaurante.getEmail());
            result = statement.executeUpdate();
            statement.close();
            if (result != 0) {
                System.out.println("Registro atualizado! (^_^)");
            } else {
                System.out.println("Registro não encontrada! ( -_-)");
            }
        } catch (SQLException ex) {
            System.out.println("Erro na atualizacao de registro ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao! ( -_-)\n" + ex);
            }
        }
    }

    public List<Restaurante> listar() {
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        Restaurante restaurante = null;
        String query = "SELECT * FROM restaurante ORDER BY RG";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                restaurante = new Restaurante();
                restaurante.setCNPJ(result.getString("CNPJ"));
                restaurante.setNomeOficial(result.getString("nome_oficial"));
                restaurante.setNomeFantasia(result.getString("nome_fantasia"));
                restaurante.setEndereco(result.getString("endereco"));
                restaurante.setEmail(result.getString("email"));
                restaurantes.add(restaurante);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Erro na pesquisa de registros ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao! ( -_-)\n" + ex);
            }
        }
        return restaurantes;
    }

}
