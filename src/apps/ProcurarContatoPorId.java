package apps;

import java.sql.SQLException;
import java.util.Scanner;
import dao.ContatoDao;
import model.Contato;

public class ProcurarContatoPorId {
	public static void executar(Scanner sc) {
		System.out.print("Procurar por qual id:");
		String idProcurado = sc.nextLine();
		
		try {
			ContatoDao cDao = new ContatoDao();
			Contato contato = cDao.procuraPorId(idProcurado);
			System.out.println();
			if (contato != null) {
			System.out.println("ID:" +contato.getId());
			System.out.println("Nome:" +contato.getNome());
			System.out.println("Email:" +contato.getEmail());
			System.out.println("Endereço:" +contato.getEndereco());
			} else {
				System.out.println("Esse id não existe.");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao acessar o banco de dados.");
		} 
								
	}
}