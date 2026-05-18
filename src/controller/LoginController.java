package controller;

import config.ConfigLoader;

public class LoginController {
	private ConfigLoader configLoader;


	public LoginController() { configLoader = ConfigLoader.getInstance(); }


	public Boolean handleLogin (String nome, String senha ) {
		return (nome.equals(configLoader.getUserName()) && senha.equals(configLoader.getUserPass()));
	}
}
