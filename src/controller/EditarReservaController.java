package controller;

import java.util.Date;
import java.util.Vector;

import database.Hospede;
import database.Reserva;
import dto.HospedeDTO;
import dto.ReservaDTO;

public class EditarReservaController {
	private Reserva reservaDao;
	
	private final Double precoPorDia = ReservaController.getPrecoPorDia();
	
	public EditarReservaController() {
		reservaDao = new Reserva();
	}
	
	public void update(Long id, Date in, Date out, Double valor, String forma) {
		reservaDao.update(id, in, out, valor, forma);		
	}
	
	public Boolean validaData(Date entrada, Date saida) {
		return (entrada != null) && (saida != null) && entrada.compareTo(saida) <= 0;
	}
	
	public Double handlePreco(Long qtdDias) {
		return (qtdDias+1) * precoPorDia;
	}
	
	
	
}
