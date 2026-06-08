package javadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsere {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			String query = "insert into contatos (nome, email, endereco) values (?,?,?) ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "Clayton");
			stmt.setString(2, "clayton@clayton.com");
			stmt.setString(3, "Rua Azul, 100");
			stmt.execute();
			stmt.close();
			System.out.println("Gravação feita no banco de dados com sucesso!!!!");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}