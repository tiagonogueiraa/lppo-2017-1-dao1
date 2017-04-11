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
    
    public List<Contato> listAll() throws Exception{
        try {
            List<Contato> contatos = new ArrayList<>();
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM contato");
            
            while(resultado.next()){
                Contato novoContato = new Contato();
                novoContato.setId(resultado.getLong("id"));
                novoContato.setNome(resultado.getString("nome"));
                novoContato.setSobrenome(resultado.getString("sobrenome"));
                novoContato.setTelefone(resultado.getString("telefone"));
                
                contatos.add(novoContato);
            }
            
                    
            
            return contatos;
        } catch (ClassNotFoundException ex) {
            throw new Exception("Driver não encotrado!", ex);
        } catch(SQLException ex){
            throw new Exception("Erro ao listar os contatos.",ex);
        }
    }
    
    
}
