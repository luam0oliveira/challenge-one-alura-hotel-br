package dto;

import java.util.Date;
import java.util.Vector;

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
	
	public static Vector<Object> convert(ReservaDTO from) {
		Vector<Object> ret = new Vector<Object>();
		ret.add(from.id);
		ret.add(from.dateIn);
		ret.add(from.dateOut);
		ret.add(from.valor);
		ret.add(from.forma);
		return ret;
	}
}
