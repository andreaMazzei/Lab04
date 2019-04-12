package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> corsi;

    @FXML
    private Button cercaIscritti;

    @FXML
    private TextField matricola;

    @FXML
    private Button trovaMatricola;

    @FXML
    private TextField nome;
    
    @FXML
    private TextArea output;

    @FXML
    private TextField cognome;

    @FXML
    private Button cercaCorsi;

    @FXML
    private Button iscrivi;

    @FXML
    private Button reset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	output.clear();
    	String testo = "";
    	int nummatr = Integer.parseInt(matricola.getText());
    	List<Corso> corsi = model.getCorsiStudente(nummatr);
    	for(Corso c : corsi)
    		testo += c.toString()+"\n";
    	if(testo.equals(""))
        	output.setText("Studente momentaneamente non iscritto ad alcun corso!");
    	else
        	output.setText(testo);
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	output.clear();
    	nome.clear();
    	cognome.clear();
    	
    	Corso c = corsi.getValue();
    	if(c==null) {
        	output.setText("Selezionare un corso!");
        	return;
    	}
    	List<Studente> iscritti = model.getIscrittiCorso(c);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(Studente s : iscritti) {
    		sb.append(String.format("%-10s", s.getMatricola()));
    		sb.append(String.format("%-20s", s.getCognome()));
    		sb.append(String.format("%-20s", s.getNome()));
    		sb.append(String.format("%-10s", s.getCds()));
    		sb.append("\n");
    	}
    	if(sb.toString().equals(""))
        	output.setText("Corso momentaneamente senza iscritti!");
    	else
        	output.appendText(sb.toString());
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	output.clear();
    	Corso c = corsi.getValue();
    	Studente s = this.doTrovaMatricola(event);
    	if(c == null)
    		output.setText("Nessun corso selezionato!");
    	if( c != null && s != null) {
    		model.iscriviStudente(c, s);
    		output.setText("Studente iscritto al corso!");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	matricola.clear();
    	nome.clear();
    	cognome.clear();
    	output.clear();
    	corsi.getSelectionModel().clearSelection();
    }

    @FXML
    Studente doTrovaMatricola(ActionEvent event) {
    	output.clear();
    	nome.clear();
    	cognome.clear();
    	boolean numeric = true;
    	Studente s = null;
    	try {
        	int nummatr = Integer.parseInt(matricola.getText());
    	}
    	catch(NumberFormatException e) {
    		numeric = false;
    	}
    	if(numeric==false)
    		output.setText("Caratteri non permessi nel campo matricola!");
    	else {
	    	int nummatr = Integer.parseInt(matricola.getText());
	    	s = model.getStudente(nummatr);
	    	if(s==null)
	    		output.setText("Studente non presente!");
	    	else {
	    		nome.setText(s.getNome());
	        	cognome.setText(s.getCognome());
	    	}
    	}
    	return s;
    }

    @FXML
    void initialize() {
        assert corsi != null : "fx:id=\"corsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaIscritti != null : "fx:id=\"cercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert trovaMatricola != null : "fx:id=\"trovaMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cercaCorsi != null : "fx:id=\"cercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert iscrivi != null : "fx:id=\"iscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        
        output.setStyle("-fx-font-family: monospace");
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	corsi.getItems().addAll(model.getCorsi());
    }
}
