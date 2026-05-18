package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import dto.HospedeDTO;

public class Hospede {
	private DataBase dataBase;
	
	public Hospede () {
		dataBase = DataBase.getInstance();
	}
	
	public Vector<HospedeDTO> getHospedes() throws Exception {
		try (Connection con = this.dataBase.getConnection()) {
			Statement stt = con.createStatement();
			ResultSet result =  stt.executeQuery("SELECT * FROM hospede;");
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
	
	public void create(String nome, String sobrenome, Date dataNasc, String naci, String telefone, Long reserva) {
		try (Connection con = this.dataBase.getConnection()){
			String update = "INSERT INTO hospede(nome, sobrenome, dataNasc, nacionalidade, telefone, reservaCod)"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement pstt = con.prepareStatement(update);
			
			pstt.setString(1, nome);
			pstt.setString(2, sobrenome);
			pstt.setDate(3, SqlUtils.from(dataNasc));
			pstt.setString(4, naci);
			pstt.setString(5, telefone);
			pstt.setLong(6, reserva);

			pstt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void delete(Long id) {
		try (Connection con = this.dataBase.getConnection()){
			String update = "DELETE FROM hospede WHERE id = ?";
			PreparedStatement pstt = con.prepareStatement(update);
			
			pstt.setLong(1, id);

			pstt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void update(Long id, String nome, String sobrenome, Date dataNasc, String naci, String telefone) {
		try (Connection con = this.dataBase.getConnection()){
			String update = "UPDATE hospede " +
					"SET nome = ?, " +
					"sobrenome = ?, " +
					"dataNasc = ?, " +
					"nacionalidade = ?, " +
					"telefone = ? " +
					"WHERE id = ?";

			PreparedStatement pstt = con.prepareStatement(update);

			pstt.setString(1, nome);
			pstt.setString(2, sobrenome);
			pstt.setDate(3, SqlUtils.from(dataNasc));
			pstt.setString(4, naci);
			pstt.setString(5, telefone);
			pstt.setLong(6, id);

			pstt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public Vector<HospedeDTO> getHospedesByTelefone(String telefone) throws Exception  {
		try (Connection con = this.dataBase.getConnection()) {
			PreparedStatement stt = con.prepareStatement("SELECT * FROM hospede WHERE telefone LIKE ?");
			stt.setString(1, telefone);
			ResultSet result =  stt.executeQuery();
			Vector<HospedeDTO> hospedes = new Vector<HospedeDTO>();
			while(result.next()) {
				Long id = result.getLong("id");
				String nome = result.getString("nome");
				String sobrenome = result.getString("sobrenome");
				Date dataNasc = result.getDate("dataNasc");
				String nacionalidade = result.getString("nacionalidade");
				String tel = result.getString("telefone");
				Long reserva = result.getLong("reservaCod");

				hospedes.add(new HospedeDTO(id, nome, sobrenome, dataNasc, nacionalidade, tel, reserva));
			}

			return hospedes;
		} catch(Exception ex) {
			throw new Exception("Problema em buscar");
		}
	}

	
}
