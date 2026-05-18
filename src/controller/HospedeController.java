package controller;

import java.rmi.server.ExportException;
import java.util.Date;
import java.util.Vector;

import database.Hospede;
import database.Reserva;
import dto.HospedeDTO;

public class HospedeController {
	
	private Hospede hospedeDao;
	
	public HospedeController() {
		this.hospedeDao = new Hospede();
	}
	
	public Boolean salvaHospede(String nome, String sobrenome, Date dataNasc, String nacionalidade, String telefone, Long numeroReserva) {
		hospedeDao.create(nome, sobrenome, dataNasc, nacionalidade, telefone, numeroReserva);
		return true;
	}

	public Boolean salvaHospede(Long id, String nome, String sobrenome, Date dataNasc, String nacionalidade, String telefone) {
		hospedeDao.update(id, nome, sobrenome, dataNasc, nacionalidade, telefone);
		return true;
	}


}
