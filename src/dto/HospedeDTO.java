package dto;

import java.util.Date;
import java.util.Vector;
import java.lang.Long;

public class HospedeDTO {
	public String nome, sobrenome, nacionalidade, telefone;
	public Date dataNasc;
	public Long reserva, id;
	
	public HospedeDTO(Long id, String nm, String sobre, Date dataNasc, String nac, String telefone, Long reserva) {
		this.id=id;
		this.nome=nm;
		this.sobrenome=sobre;
		this.dataNasc=dataNasc;
		this.nacionalidade=nac;
		this.telefone=telefone;
		this.reserva=reserva;
	}
	
	// Talvez o mais correto seria enviar os dados num formato Vector<HospedeDTO>
	// e depois cuidar da conversao diretamente na view
	public static Vector<Object> convert(HospedeDTO from) {
		Vector<Object> ret = new Vector<Object>();
		ret.add(from.id);
		ret.add(from.nome);
		ret.add(from.sobrenome);
		ret.add(from.dataNasc);
		ret.add(from.nacionalidade);
		ret.add(from.telefone);
		ret.add(from.reserva);
		return ret;
	}
}
