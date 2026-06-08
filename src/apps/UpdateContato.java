package apps;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.ContatoDao;

public class UpdateContato {

	public static void executar(Scanner sc) {
		List<String> opcoesValidas = List.of("1", "2", "3");
		
		System.out.println("Qual é o id do contato que você quer alterar?");
		Long idContato = sc.nextLong();
		sc.nextLine();
		
		String escolha;
		do {
			System.out.println("Qual coluna você quer alterar?\n1 - Nome\n2 - Email\n3 - Endereco");
			escolha = sc.nextLine();
					} while (!opcoesValidas.contains(escolha));
		
		String coluna = "";
		switch (escolha) {
	    case "1":
	        coluna = "nome";
	        break;
	    case "2":
	        coluna = "email";
	        break;
	    case "3":
	    	coluna = "endereco";
	    	break;
	}
		
		System.out.println("Qual é o novo "+coluna+"?");
		String novoValor = sc.nextLine();
		int linhas = 0;
		
		try {
			ContatoDao cDao = new ContatoDao();
			linhas = cDao.altera(coluna, novoValor, idContato);
		} catch (SQLException e) {
			System.out.println("Erro no acesso ao banco de dados.");
		}
		if (linhas == 0) {
			System.out.println("Nenhuma alteração foi feita porque o id não existe.");
		} else {
			System.out.println("Alteração realizada com sucesso.");
		}
	}

}
