package database;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

import dto.HospedeDTO;

public class Hospede {
	private DataBase dataBase;
	
	public Vector<HospedeDTO> getHospedes() throws Exception {
		try {
			ResultSet result =  this.dataBase.executeQuery("SELECT * FROM HOSPEDE;");
			Vector<HospedeDTO> hospedes = new Vector<HospedeDTO>();
			while(result.next()) {
				Long id = result.getLong("id");
				String nome = result.getString("nome");
				String sobrenome = result.getString("sobrenome");
				Date dataNasc = result.getDate("dataNasc");
				String nacionalidade = result.getString("nacionalidade");
				String telefone = result.getString("telefone");
				Long reserva = result.getLong("reservaCod");
				
				hospedes.add(new HospedeDTO(id, nome, sobrenome, dataNasc, nacionalidade, telefone, reserva));
			}
			
			return hospedes;
		} catch(Exception ex) {
			throw new Exception("Problema");
		}
		
	}
}
