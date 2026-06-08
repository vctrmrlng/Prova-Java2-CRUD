package apps;

import java.sql.SQLException;
import java.util.Scanner;
import dao.ContatoDao;

public class ApagarContato {

	public static void executar(Scanner sc) {
		System.out.println("Qual é o id do contato que você quer apagar?");
		long idContato = sc.nextLong();
		sc.nextLine();
		
		int linhas = 0;
		
		try {
			ContatoDao cDao = new ContatoDao();
			linhas = cDao.remove(idContato);
			
		} catch (SQLException e) {
			System.out.println("Erro no acesso ao banco de dados.");
		}
		if (linhas == 0) {
			System.out.println("Nenhuma contato foi removido porque o id não existe.");
		} else {
			System.out.println("Contato removido com sucesso.");
		}

	}

}
