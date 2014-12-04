package com.tms.corso;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Studente implements Serializable{

	private String nome;
	private String cognome;
	private Date dataNascita;
	private String linguaggioPreferito;
	private String titoloDiStudio;
	private double mediaVoti;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public Studente(String nome, String cognome, Date dataNascita,
			String linguaggioPreferito, String titoloDiStudio, double mediaVoti) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.linguaggioPreferito = linguaggioPreferito;
		this.titoloDiStudio = titoloDiStudio;
		this.mediaVoti = mediaVoti;
	}

//	@Override
//	public int hashCode() {
//		return nome.hashCode()+7*cognome.hashCode();
//	
//	}

	@Override
	public String toString() {
		return "(" + nome + " " + cognome + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String toFileLine() {
		
		return String.format("%s=%s=%s=%s=%s=%.0f", nome, cognome, df.format(dataNascita), linguaggioPreferito, titoloDiStudio, mediaVoti );
	}

//	@Override
//	public boolean equals(Object arg0) {
//		if (this.getClass() != arg0.getClass()) {
//			return false;
//		}
//		Studente altro = (Studente) arg0;
//
//		if (!nome.equals(altro.nome) || !cognome.equals(altro.cognome)) {
//			return false;
//		}
//		return true;
//
//		// return super.equals(arg0);
//	}

}
