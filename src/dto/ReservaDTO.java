package dto;

import java.util.Date;

public class ReservaDTO {
	public Date dateIn, dateOut;
	public Long id;
	public String forma;
	public Double valor;
	
	public ReservaDTO(Long id, Date in, Date out, Double valor, String forma) {
		this.id = id;
		this.dateIn = in;
		this.dateOut = out;
		this.forma = forma;
		this.valor = valor;		
	}
}
