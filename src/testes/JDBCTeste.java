package javadb;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTeste {

    public static void main(String[] args) {

        String stringDeConexao = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "";

        try {
            DriverManager.getConnection(stringDeConexao, user, password);
            System.out.println("Conectado ao Banco de Dados \\o//");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    	}
		}