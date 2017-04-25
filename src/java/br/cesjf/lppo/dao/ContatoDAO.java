package br.cesjf.lppo.dao;

import br.cesjf.lppo.Contato;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Nogueira
 */
public class ContatoDAO {

    public List<Contato> listAll() throws Exception {
        try {
            List<Contato> contatos = new ArrayList<>();

            Connection conexao = ConnectionFactory.createConnection();

            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM contato");

            while (resultado.next()) {
                Contato novoContato = new Contato();
                novoContato.setId(resultado.getLong("id"));
                novoContato.setNome(resultado.getString("nome"));
                novoContato.setSobrenome(resultado.getString("sobrenome"));
                novoContato.setTelefone(resultado.getString("telefone"));

                contatos.add(novoContato);
            }

            return contatos;
        } catch (SQLException ex) {
            throw new Exception("Erro ao listar os contatos.", ex);
        }
    }

    public void cria(Contato novoContato) throws Exception {
        try {

            Connection conexao = ConnectionFactory.createConnection();

            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("INSERT INTO contato(nome,sobrenome,telefone) VALUES('"
                    + novoContato.getNome() + "','"
                    + novoContato.getSobrenome() + "','"
                    + novoContato.getTelefone() + "')");

        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir o contato!", ex);
        }

    }
}
