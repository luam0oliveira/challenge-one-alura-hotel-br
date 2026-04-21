package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.ConfigLoader;

public class DataBase {	
	private String database;
	private String incompleteUrl;
	private String url;
	private String user;
	private String password;
	
	private static DataBase instance;
	
	public static DataBase getInstance() {
		if (instance == null) {
			ConfigLoader configs = ConfigLoader.getInstance();
			instance = new DataBase(configs.getDatabaseName(), configs.getDatabaseUrl(),
					configs.getDatabaseUser(), configs.getDatabasePassword());
		}
		
		return instance;
	}
	
	
	private DataBase(String database, String url, String user, String password) {
		this.database = database;
		this.incompleteUrl = url;
		this.user = user;
		this.password = password;
		this.url = this.incompleteUrl+this.database;
	}

	public void createDatabase() {
		
		try(Connection conn = DriverManager.getConnection(url, user, password)) {
		} catch(Exception e) {
			try (Connection conn = DriverManager.getConnection(incompleteUrl, user, password); Statement stt = conn.createStatement()) {
				stt.execute("CREATE DATABASE "+database+";");
			} catch (Exception e2) {
				System.out.println("ERRO FATAL!");
			}
		}
		
		try(Connection conn = DriverManager.getConnection(url,user, password)) {
			Statement stt = conn.createStatement();

			
			// cria tabela reserva
			String query = "CREATE TABLE IF NOT EXISTS reserva(\n"
					+ "  id BIGINT AUTO_INCREMENT PRIMARY KEY,\n"
					+ "  dataIn Date not NULL,\n"
					+ "  dataOut Date NOT NULL,\n"
					+ "  valor FLOAT not NULL,\n"
					+ "  forma VARCHAR(30) not NULL\n"
					+ ");\n";
			stt.addBatch(query);
			
			// cria tabela funcionario
			query = "CREATE TABLE IF NOT EXISTS funcionario (\n"
					+ "  usuario VARCHAR(25) PRIMARY KEY,\n"
					+ "  senha VARCHAR(255) NOT NULL\n"
					+ " );\n";
			stt.addBatch(query);
			
			// cria tabela hospede
			query = "CREATE TABLE IF NOT EXISTS hospede(\n"
					+ "id BIGINT AUTO_INCREMENT PRIMARY KEY,\n"
					+ "nome VARCHAR(50),\n"
					+ "sobrenome VARCHAR(255),\n"
					+ "dataNasc DATE,\n"
					+ "nacionalidade VARCHAR(50),\n"
					+ "telefone VARCHAR(25),\n"
					+ "reservaCod BIGINT NOT NULL,\n"
					+ "FOREIGN KEY (reservaCod) REFERENCES reserva(id) ON DELETE CASCADE\n"
					+ ");";
			stt.addBatch(query);
			stt.executeBatch();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		try(Connection conn = DriverManager.getConnection(url,user, password)) {
			Statement stt = conn.createStatement();
			ResultSet sttResult = stt.executeQuery(query);
			return sttResult;
		} catch(Exception ex) {
			throw new SQLException(ex.getMessage());
		}
	}
}
