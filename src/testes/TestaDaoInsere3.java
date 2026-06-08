package testes;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import dao.ContatoDao;
import model.Contato;

public class TestaDaoInsere3 {
	public static void main(String[] args) {
		Contato contato = new Contato();
				
		contato.setNome(JOptionPane.showInputDialog("Digite seu nome:"));
		contato.setEmail(JOptionPane.showInputDialog("Digite seu email:"));
		contato.setEndereco(JOptionPane.showInputDialog("Digite seu Endereço:"));
				
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação realizada com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

}
