package apps;

import java.sql.SQLException;
import java.util.Scanner;
import dao.ContatoDao;
import model.Contato;

public class InserirContato {
	public static void executar(Scanner sc) {
		Contato contato = new Contato();
		
		System.out.println("Digite o Nome:");
		contato.setNome(sc.nextLine());
		
		System.out.println("Digite o Email:");
		contato.setEmail(sc.nextLine());

		System.out.println("Digite o Endereço:");
		contato.setEndereco(sc.nextLine());
		
	
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação realizada com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

}
