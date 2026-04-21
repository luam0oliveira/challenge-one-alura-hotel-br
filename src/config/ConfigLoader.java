package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private String databaseUrl;
	private String databaseUser;
	private String databaseName;
	private String databasePassword;
	
	private static ConfigLoader instance;
	
	public static ConfigLoader getInstance() {
		if (instance == null) {
			instance = new ConfigLoader();
		}
		
		return instance;
	}
	
	private ConfigLoader() {
		Properties properties = new Properties();
		
		try(InputStream input = new FileInputStream("config.properties")) {
			properties.load(input);
			this.databaseName = properties.getProperty("database_name");
			this.databaseUrl = properties.getProperty("database_url");
			this.databaseUser = properties.getProperty("database_user");
			this.databasePassword = properties.getProperty("database_password");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Nao foi possivel encontrar as informacoes de configuracao");
		}
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public String getDatabaseUser() {
		return databaseUser;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}
	
	
}
