package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Iscrizione;
import it.polito.tdp.lab04.model.Studente;

public class IscrizioneDAO {
	public List<Studente> getAllIscrizioni(String codins) {
		
		final String sql = "SELECT * FROM studente WHERE matricola IN (SELECT matricola FROM iscrizione WHERE codins = ?)";

		List<Studente> studentiIscrittiCorso = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins); //DEVO METTERE AL POSTO DEI ? QUELLO CHE VOGLIO SCRIVERE
									 // PARTO DA 1

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("cds");
				

				System.out.println(matricola + " " + cognome + " " + nome + " " + cds);

				Studente s = new Studente(matricola, cognome, nome, cds);
				studentiIscrittiCorso.add(s);
			}
			
			//conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return studentiIscrittiCorso;

	}

	public void iscriviStudente(Corso c, Studente s) {
		
		final String sql = "INSERT IGNORE INTO `iscritticorsi`.`iscrizione` (`matricola`, `codins`) VALUES(?,?)";
		
						// ATTENZIONE A QUANDO INSERICI ELEMENTI NEL DB A USARE `` E NON '' !!!!!!
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, s.getMatricola());
			st.setString(2, c.getCodins());

			int rs = st.executeUpdate();

			//conn.close();
			
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
}
