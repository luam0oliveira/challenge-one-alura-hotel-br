package controller;

import java.util.Date;

import database.Hospede;
import database.Reserva;

public class HospedeController {
	
	private Hospede hospedeDao;
	
	public HospedeController() {
		this.hospedeDao = new Hospede();
	}
	
	public Boolean salvaHospede(String nome, String sobrenome, Date dataNasc, String nacionalidade, String telefone, Long numeroReserva) {
		hospedeDao.create(nome, sobrenome, dataNasc, nacionalidade, telefone, numeroReserva);
		return true;
	}
}
