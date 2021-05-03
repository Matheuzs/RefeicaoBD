package DAO;

import Conexao.Conexao;
import Modelo.Cliente;
import Modelo.Restaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        String query = "INSERT INTO CLIENTE(NOME,CPF,RG) VALUES (?,?,?)";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCPF().toString());
            statement.setString(2, cliente.getRG().toString());
            statement.execute();
            statement.close();
            System.out.println("Registro adicionado em CLIENTE. (^_^)");
            new ClienteDAO().inserir(cliente);
        } catch (SQLException ex) {
            System.out.println("Erro na inclusao de registro em CLIENTE. ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em CLIENTEDAO. ( -_-)\n" + ex);
            }
        }
    }

    public void excluir(String RG) {
        String query = "DELETE FROM CLIENTE WHERE RG = ?";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        int result = 0;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, "" + RG);
            result = statement.executeUpdate();
            statement.close();
            if (result != 0) {
                System.out.println("Registro removido em CLIENTE. (^_^)");
                new ClienteDAO().excluir(RG);
                System.out.println("Registro não encontrado em CLIENTE. (-_- )");
            }
        } catch (SQLException ex) {
            System.out.println("Erro na exclusao de registro em CLIENTE. ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em CLIENTEDAO. ( -_-)\n" + ex);
            }
        }
    }

    public void atualizar(Cliente cliente) {
        String query = "UPDATE CLIENTE SET NOME = ? WHERE RG = ?";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        int result = 0;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, cliente.getNome());
            result = statement.executeUpdate();
            statement.close();
            if (result != 0) {
                System.out.println("Registro atualizado em CLIENTE. (^_^)");
            } else {
                System.out.println("Registro não encontrado em CLIENTE. (-_- )");
            }
        } catch (SQLException ex) {
            System.out.println("Erro na atualizacao de registro EM cliente. ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em CLIENTEDAO. ( -_-)\n" + ex);
            }
        }
    }

    public List<Cliente> listar() {
        System.out.println("LISTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        List<Cliente> clientes = new ArrayList<Cliente>();
        String query = "SELECT * FROM cliente ORDER BY NOME";
        Cliente cliente = null;
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            System.out.println("CAIUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            while (result.next()) {
                cliente = new Cliente();
                cliente.setNome(result.getString("NOME"));
                cliente.setCPF(Integer.parseInt(result.getString("CPF")));
                cliente.setRG(Integer.parseInt(result.getString("RG")));
                clientes.add(cliente);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Erro na pesquisa de registros. ( -_-)\n" + ex);
            JOptionPane.showMessageDialog(null, "Nao foi possivel carregar o driver\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em CLIENTEDAO. ( -_-)\n" + ex);
            }
        }
        return clientes;
    }

    public Cliente listarPorRG(Integer RG) {
        Cliente cliente = null;
        String query = "SELECT * FROM CLIENTE WHERE RG = ?";
        PreparedStatement statement = null;
        Connection connection = Conexao.getInstance().getConnection();
        ResultSet result = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, RG.toString());
            result = statement.executeQuery();
            if (result.next()) {
                cliente = new Cliente();
                cliente.setNome(result.getString("NOME"));
                cliente.setRG(Integer.parseInt(result.getString("RG")));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Erro na busca de registro em CLIENTE. ( -_-)\n" + ex);
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Nao foi possivel fechar a conexao em CLIENTEDAO. ( -_-)\n" + ex);
            }
        }
        return cliente;
    }

}
