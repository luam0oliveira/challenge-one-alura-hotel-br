package dto;

import java.util.Date;
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
}
