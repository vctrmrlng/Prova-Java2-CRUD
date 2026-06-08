package apps;

import java.sql.SQLException;
import java.util.List;
import dao.ContatoDao;
import model.Contato;

public class ListarContatos {

	public static void executar() {
		try {
			ContatoDao contatoDao = new ContatoDao();
			List<Contato> contatos = contatoDao.getLista();
			
			for (Contato contato : contatos) {
				System.out.println("Id do Contato >> " +contato.getId());
				System.out.println("Nome do Contato >> " +contato.getNome());
				System.out.println("Email do Contato >> " +contato.getEmail());
				System.out.println("Endereço do Contato >> " +contato.getEndereco());
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
