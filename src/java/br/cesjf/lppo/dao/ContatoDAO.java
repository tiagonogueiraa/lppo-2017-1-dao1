package br.cesjf.lppo.dao;

import br.cesjf.lppo.Contato;
import java.sql.Connection;
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
    private PreparedStatement opAtualiza;
    private PreparedStatement opBuscaPorId;

    public ContatoDAO() throws Exception {
        Connection conexao = ConnectionFactory.createConnection();
        opListar = conexao.prepareStatement("SELECT * FROM contato");
        opBuscaPorId = conexao.prepareStatement("SELECT * FROM contato WHERE id=?");
        opNovo = conexao.prepareStatement("INSERT INTO contato (nome, sobrenome, telefone) VALUES(?,?,?)");
        opAtualiza = conexao.prepareStatement("UPDATE contato SET nome = ?, sobrenome = ?, telefone = ? WHERE id = ?");
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
    
    public Contato getById(Long id) throws Exception {
        try {
            Contato contato = null;
            opBuscaPorId.clearParameters();
            opBuscaPorId.setLong(1, id);
            ResultSet resultado = opBuscaPorId.executeQuery();

            while (resultado.next()) {
                Contato novoContato = new Contato();
                novoContato.setId(resultado.getLong("id"));
                novoContato.setNome(resultado.getString("nome"));
                novoContato.setSobrenome(resultado.getString("sobrenome"));
                novoContato.setTelefone(resultado.getString("telefone"));

               
            }

            return contato;
        } catch (SQLException ex) {
            throw new Exception("Erro ao buscar um contato no listar!", ex);
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
    
    public void atualiza(Contato contato) throws Exception {
        try {
            opAtualiza.clearParameters();
            opAtualiza.setString(1, contato.getNome());
            opAtualiza.setString(2, contato.getSobrenome());
            opAtualiza.setString(3, contato.getTelefone());
            opAtualiza.setLong(4, contato.getId());
            opAtualiza.executeUpdate();


        } catch (SQLException ex) {
            throw new Exception("Erro ao atualizar o contato!", ex);
        }
}

 
}
