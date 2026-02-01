package controller;

import java.util.Date;

public class ReservaController {
	private final Double precoPorDia = 150.00;
	
	public Boolean validaData(Date entrada, Date saida) {
		return (entrada != null) && (saida != null) && entrada.compareTo(saida) <= 0;
	}
	
	public Double handlePreco(Long qtdDias) {
		return (qtdDias+1) * precoPorDia;
	}
}
