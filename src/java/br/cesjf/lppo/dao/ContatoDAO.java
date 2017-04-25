package br.cesjf.lppo.dao;

import br.cesjf.lppo.Contato;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Nogueira
 */
public class ContatoDAO {
    private PreparedStatement opListar;
    private PreparedStatement opNovo;

    public ContatoDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM contato");
        opNovo = conexao.prepareStatement("INSERT INTO contato (nome, sobrenome, telefone) VALUES(?,?,?)");
    }
    
    
    public List<Contato> listAll() throws Exception {
        try {
            List<Contato> contatos = new ArrayList<>();
            ResultSet resultado = opListar.executeQuery();

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

            opNovo.setString(1, novoContato.getNome());
            opNovo.setString(2, novoContato.getSobrenome());
            opNovo.setString(3, novoContato.getTelefone());
            opNovo.executeUpdate();


        } catch (SQLException ex) {
            throw new Exception("Erro ao inserir o contato!", ex);
        }

    }
}
