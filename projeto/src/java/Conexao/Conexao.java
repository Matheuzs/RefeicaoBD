/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    private static Conexao conexao;
    private ResourceBundle configuracao;

    private Conexao() {
        this.configuracao = ResourceBundle.getBundle("configuracoes.configuracao");
    }

    public static Conexao getInstance() {
        if (conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            //Carregar o driver
            Class.forName(configuracao.getString("driver"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel carregar o driver\n" + ex);
        }
        try {
            connection = DriverManager.getConnection(configuracao.getString("url"), configuracao.getString("usuario"), configuracao.getString("senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel criar uma conexao com o BD\n" + ex);
        }
        return connection;
    }

}
