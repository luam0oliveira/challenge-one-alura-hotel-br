package main;

import database.DataBase;
import views.Login;

public class Main {
	public static void main(String[] args) {
		try {
			// Carrega o banco
			DataBase database = DataBase.getInstance();
			
			// Cria o banco de dados
			database.createDatabase();
			
			// Inicializa a tela de login
			Login.main(null);
		} catch (Exception e) {
			System.out.println("Ocorreu erro");
		}
	}
}
