package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Iscrizione;
import it.polito.tdp.lab04.model.Studente;

public class IscrizioneDAO {
	public List<Iscrizione> getAllIscrizioni(String codins) {
		
		final String sql = "SELECT * FROM studente WHERE matricola IN (SELECT matricola FROM iscrzione WHERE codins = ?)";

		List<Iscrizione> iscrizioni = new LinkedList<Iscrizione>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				//String codins = rs.getString("codins");		

				System.out.println(matricola + " " + codins);

				Iscrizione i = new Iscrizione(matricola, codins);
				iscrizioni.add(i);
			}

			return iscrizioni;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
}
