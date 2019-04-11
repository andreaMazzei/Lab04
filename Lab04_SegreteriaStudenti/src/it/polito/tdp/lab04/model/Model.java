package it.polito.tdp.lab04.model;


import java.util.List;


import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.IscrizioneDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public List<Corso> getCorsi() {
		CorsoDAO dao = new CorsoDAO();
		return dao.getTuttiICorsi();
	}
	
	public Studente getStudente(int matricola) {
		StudenteDAO dao = new StudenteDAO();
		return dao.getStudente(matricola);
	}
	
	public List<Studente> getIscrittiCorso(Corso c) {
		IscrizioneDAO dao = new IscrizioneDAO();
		return dao.getAllIscrizioni(c.getCodins());
	}

	public List<Corso> getCorsiStudente(int matricola) {
		CorsoDAO dao = new CorsoDAO();
		return dao.getCorsiStudente(matricola);
	}

	public void iscriviStudente(Corso c, Studente s) {
		IscrizioneDAO dao = new IscrizioneDAO();
		dao.iscriviStudente(c, s);
	}
	
}
