package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javadb.ConnectionFactory;
import model.Contato;

public class ContatoDao {
	private Connection con;
	
	public ContatoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();		
	}
	
	public void adiciona (Contato contato) throws SQLException {
		String insert = "insert into contatos (nome, email, endereco) values (?,?,?) ";
		PreparedStatement stmt = con.prepareStatement(insert);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.execute();
		stmt.close();
		con.close();
		}
	
	// 1 - A principio criei o metodo altera com return void como os outros, mas depois descobri que execUpdate retorna um int equivalente 
	// ao numero de linhas alteradas no banco de dados. Esse número é necessario no projeto atual para saber se o id do contato que se 
	// tentou alterar existe. Conforme a separação adotada no projeto (DAO + aplicação principal), esse tratamento é feio no app UpdateContato
	
	public int altera (String coluna, String novoValor, long idContato) throws SQLException {
		String update = "UPDATE contatos SET " + coluna + " = ? WHERE id = ?;";
		PreparedStatement stmt = con.prepareStatement(update);
		stmt.setString(1, novoValor);
		stmt.setLong(2, idContato);
		int linhas = stmt.executeUpdate();
		stmt.close();
		con.close();
		return linhas;
	}
	
	public List<Contato> procuraPorLetra(String letraProcurada) throws SQLException {
		String search = "SELECT * FROM contatos WHERE nome LIKE '" +letraProcurada + "%'";
		PreparedStatement stmt = con.prepareStatement(search);
		ResultSet rset = stmt.executeQuery();
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setId(rset.getLong("id"));
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contatos.add(contato);
		}
		
		rset.close();
		stmt.close();
		con.close();
				
		return contatos;
	}

	public Contato procuraPorId(String idProcurado) throws SQLException {
		String search = "SELECT * FROM contatos WHERE id = " + idProcurado +";";
		PreparedStatement stmt = con.prepareStatement(search);
		ResultSet rset = stmt.executeQuery();
		Contato contato = null;
		
		if (rset.next()) {
			contato = new Contato();
			
			contato.setId(rset.getLong("id"));
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			}
		
		rset.close();
		stmt.close();
		con.close();

		return contato;
	}
	
	public List<Contato> getLista() throws SQLException {
		String select = "select * from contatos";
		PreparedStatement stmt = con.prepareStatement(select);
		ResultSet rset = stmt.executeQuery();
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setId(rset.getLong("id"));
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contatos.add(contato);
		}
		
		rset.close();
		stmt.close();
		con.close();
		
		return contatos;
	
	}
	// Assim como no metodo de update, o metodo de delete precisa retornar o int linhas que informa o numero de linhas alteradas
	
	public int remove(long idContato) throws SQLException {
		String apaga = "DELETE FROM contatos WHERE id = ? ;";
		PreparedStatement stmt = con.prepareStatement(apaga);
		stmt.setLong(1, idContato);
		int linhas = stmt.executeUpdate();
		return linhas;	
	} 
}

















