package apps;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import dao.ContatoDao;
import model.Contato;

public class ProcurarContatoPorLetra {
	public static void executar(Scanner sc) {
		
		System.out.print("Procurar por qual letra?");
		String letraProcurada = sc.nextLine();
		
		try {
			ContatoDao cDao = new ContatoDao();
			List<Contato> contatos = cDao.procuraPorLetra(letraProcurada);
			if (contatos.isEmpty()) {
				System.out.println("\nNenhum contato com essa letra.");
			} else {
				for (Contato contato : contatos) {
					System.out.println();
					System.out.println("Id:" + contato.getId());
					System.out.println("Nome:" + contato.getNome());
					System.out.println("Email:" + contato.getEmail());
					System.out.println("Endereço:" + contato.getEndereco());
				}

			}

		} catch (SQLException e) {
			System.out.println("Erro no acesso ao banco de dados.");

		}

	}
}