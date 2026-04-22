package controller;

import java.util.Date;

import database.Reserva;

public class ReservaController {
	private static final Double precoPorDia = 150.00;
	
	private static Long reserva = 0L;
	
	private Reserva reservaDao;
	
	public ReservaController() {
		this.reservaDao = new Reserva();
	}
	
	public Boolean validaData(Date entrada, Date saida) {
		return (entrada != null) && (saida != null) && entrada.compareTo(saida) <= 0;
	}
	
	public Double handlePreco(Long qtdDias) {
		return (qtdDias+1) * precoPorDia;
	}
	
	public Long getReserva() {
		increaseReserva();
		return reserva;
	}
	
	public static void increaseReserva() {
		reserva+=1;
	}
	
	public static Double getPrecoPorDia() {
		return precoPorDia;
	}
	
	public Long createReserva(Date in, Date out, Double valor, String forma) {
		return reservaDao.create(in, out, valor, forma);
	}
}
