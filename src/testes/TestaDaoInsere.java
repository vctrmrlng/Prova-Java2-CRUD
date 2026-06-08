package testes;

import java.sql.SQLException;
import dao.ContatoDao;
import model.Contato;

public class TestaDaoInsere {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Filipe");
		contato.setEmail("filipe@troti.com");
		contato.setEndereco("Rua Feliz, 616");
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação realizada com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

}
