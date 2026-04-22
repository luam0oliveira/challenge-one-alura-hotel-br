package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import dto.ReservaDTO;

public class Reserva {
	private DataBase dataBase;
	
	public Reserva () {
		dataBase = DataBase.getInstance();
	}
	
	public Vector<ReservaDTO> getReservas() throws Exception {
		try (Connection con = this.dataBase.getConnection()){
			Statement stt = con.createStatement();
			ResultSet result = stt.executeQuery("SELECT * FROM reserva;");
			Vector<ReservaDTO> reservas = new Vector<>();
			
			while(result.next()) {
				Long id = result.getLong("id");
				Date in = result.getDate("dataIn");
				Date out = result.getDate("dataOut");
				Double valor = result.getDouble("valor");
				String forma = result.getString("forma");
				
				reservas.add(new ReservaDTO(id, in, out, valor, forma));
			}
			
			return reservas;
		} catch(Exception ex) {
			throw new Exception("Problema");
		}
		
	}
	
	// funfact: no linux(por padrao) o nome das tabelas eh case-sensitive
	public Long create(Date in, Date out, Double valor, String forma) {
		try (Connection con = this.dataBase.getConnection()){
			String update = "INSERT INTO reserva(DataIn, DataOut, valor, forma) VALUES(?,?,?,?)";
			PreparedStatement pstt = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
			
			pstt.setDate(1, SqlUtils.from(in));
			pstt.setDate(2, SqlUtils.from(out));
			pstt.setDouble(3, valor);
			pstt.setString(4, forma);
			pstt.execute();
			ResultSet rs = pstt.getGeneratedKeys();
			
			Long ret = -1L;
			
			if (rs.next()) {
				ret = rs.getLong(1); 
			}
			
			return ret;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1L;
		}
	}
	
	public void delete(Long id) {
		try (Connection con = this.dataBase.getConnection()){
			String update = "DELETE FROM reserva WHERE id = ?";
			PreparedStatement pstt = con.prepareStatement(update);
			
			pstt.setLong(1, id);

			pstt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void update(Long id, Date in, Date out, Double valor, String forma) {
		try (Connection con = this.dataBase.getConnection()){
			String update = "UPDATE reserva SET"
					+ " DataIn = ?, DataOut = ?, valor = ?, forma = ?"
					+ " WHERE id = ?";
			PreparedStatement pstt = con.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
			
			pstt.setDate(1, SqlUtils.from(in));
			pstt.setDate(2, SqlUtils.from(out));
			pstt.setDouble(3, valor);
			pstt.setString(4, forma);
			pstt.setLong(5, id);
			pstt.execute();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
