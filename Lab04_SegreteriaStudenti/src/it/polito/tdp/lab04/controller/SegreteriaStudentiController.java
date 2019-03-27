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

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	Corso c = corsi.getValue();
    	String testo="";
    	List<Studente> iscritti = c.getStudenti();
    	for(Studente s : iscritti)
    		testo += s.toString()+"\n";
    	output.setText(testo);
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTrovaMatricola(ActionEvent event) {
    	int nummatr = Integer.parseInt(matricola.getText());
    	Studente s = model.getStudente(nummatr);
    	nome.setText(s.getNome());
    	cognome.setText(s.getCognome());
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

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	corsi.getItems().addAll(model.getCorsi());
    }
}
