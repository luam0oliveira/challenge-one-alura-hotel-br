package controller;

import java.util.Date;

public class ReservaController {
	private final Double precoPorDia = 150.00;
	
	private static Long reserva = 0L;
	
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
}
