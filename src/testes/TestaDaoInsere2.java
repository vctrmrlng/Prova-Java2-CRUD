package testes;

import java.sql.SQLException;
import java.util.Scanner;

import dao.ContatoDao;
import model.Contato;

public class TestaDaoInsere2 {
	public static void main(String[] args) {
		Contato contato = new Contato();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o Nome:");
		contato.setNome(sc.nextLine());
		
		System.out.println("Digite o Email:");
		contato.setEmail(sc.nextLine());

		System.out.println("Digite o Endereço:");
		contato.setEndereco(sc.nextLine());
		
		sc.close();
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação realizada com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

}
