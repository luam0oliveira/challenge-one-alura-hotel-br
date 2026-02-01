package controller;

public class LoginController {
	public Boolean handleLogin (String nome, String senha ) {
		return (nome.equals("admin") && senha.equals("1234"));
	}
}
