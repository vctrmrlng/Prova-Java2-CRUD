package apps;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String escolhaMain = "";
		List<String> opcoesValidas = List.of("1", "2", "3", "4", "5", "6", "7");

		do {
			System.out.println("Bem vindo ao sistema CRUD Experimental!!");
			System.out.println("Escolha qual ação você quer executar:");
			System.out.println("1 - Inserir um novo contato");
			System.out.println("2 - Listar todos os contatos");
			System.out.println("3 - Buscar contatos pela(s) primeira(s) letra(s)");
			System.out.println("4 - Buscar contato por ID");
			System.out.println("5 - Alterar contato");
			System.out.println("6 - Excluir contato");
			System.out.println("7 - Encerrar");
			escolhaMain = scan.nextLine();

			if (!opcoesValidas.contains(escolhaMain)) {
				System.out.println("Opção inválida!");
				continue;
			}

			switch (escolhaMain) {
			case "1":
				InserirContato.executar(scan);
				break;
			case "2":
				ListarContatos.executar();
				break;
			case "3":
				ProcurarContatoPorLetra.executar(scan);
				break;
			case "4":
				ProcurarContatoPorId.executar(scan);
				break;
			case "5":
				UpdateContato.executar(scan);
				break;
			case "6":
				ApagarContato.executar(scan);
				break;
			case "7":
				System.out.println("Obrigado por usar nosso sistema. Volte Sempre!");
			}
			System.out.println("");
		} while (!escolhaMain.equals("7"));
		scan.close();

	}
}
