package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

public class Studente {
	private int matricola;
	private String cognome;
	private String nome;
	private String cds;
	
	private List<Corso> iscrizioni = new ArrayList<Corso>();


	public Studente(int matricola, String cognome, String nome, String cds) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
	}


	public int getMatricola() {
		return matricola;
	}



	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCds() {
		return cds;
	}



	public void setCds(String cds) {
		this.cds = cds;
	}



	public List<Corso> getIscrizioni() {
		return iscrizioni;
	}



	public void setIscrizioni(List<Corso> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}

	public void addCorso(Corso c) {
		for(Corso cor : iscrizioni) {
			if(cor.equals(c))
				return;
			else
				iscrizioni.add(c);
		}
	}


	@Override
	public String toString() {
		return matricola + " " + cognome + " " + nome + " " + cds;
	}
	
	 
}
