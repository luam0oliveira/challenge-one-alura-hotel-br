package controller;

import java.util.Vector;

import database.Hospede;
import database.Reserva;
import dto.HospedeDTO;
import dto.ReservaDTO;

public class BuscarController {
	private Hospede hospedeDao;
	private Reserva reservaDao;
	
	public BuscarController() {
		hospedeDao = new Hospede();
		reservaDao = new Reserva();
	}
	
	public Vector<Vector<Object>> getAllHospedes() {
		Vector<Vector<Object>> hospedes = new Vector<>();
		try {
			Vector<HospedeDTO> hospedesRaw = hospedeDao.getHospedes(); 
			
			for(HospedeDTO h: hospedesRaw) {
				hospedes.add(HospedeDTO.convert(h));
			}
		
		} catch(Exception e) {
			// treat
		}
		return hospedes;
	}
	
	public Vector<Vector<Object>> getAllReservas() {
		Vector<Vector<Object>> reservas = new Vector<>();
		try {
			Vector<ReservaDTO> reservasRaw = reservaDao.getReservas(); 
			
			for(ReservaDTO h: reservasRaw) {
				reservas.add(ReservaDTO.convert(h));
			}
		
		} catch(Exception e) {
			// treat
		}
		return reservas;
	}
	
	public void deleteReserva(Long id) {
		reservaDao.delete(id);
	}
	
	public void deleteHospede(Long id) {
		hospedeDao.delete(id);	
	}

	public Vector<Vector<Object>> findHospedeByTelefone(String telefone) {
		Vector<Vector<Object>> hospedes = new Vector<>();
		try {
			Vector<HospedeDTO> hospedesRaw = hospedeDao.getHospedesByTelefone(telefone);

			for(HospedeDTO h: hospedesRaw) {
				hospedes.add(HospedeDTO.convert(h));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return hospedes;
	}

	public Vector<Vector<Object>> getReservaByNumeroReserva(Long id) {
		Vector<Vector<Object>> reservas = new Vector<>();
		try {
			Vector<ReservaDTO> reservasRaw = reservaDao.getReservasById(id);

			for(ReservaDTO h: reservasRaw) {
				reservas.add(ReservaDTO.convert(h));
			}

		} catch(Exception e) {
			// treat
		}
		return reservas;
	}

}
