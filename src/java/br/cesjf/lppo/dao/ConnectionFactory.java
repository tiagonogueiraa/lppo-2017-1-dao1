/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ConnectionFactory {

    private static final String URL = "jdbc:derby://localhost:1527/lppo-2017-1";
    private static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String USER = "usuario";
    private static final String PASSWORD = "senha";

    public static Connection createConnection() throws Exception {
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao carreagr o Driver!", ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao criar a conexao!", ex);
        }

        return conexao;

    }
}
