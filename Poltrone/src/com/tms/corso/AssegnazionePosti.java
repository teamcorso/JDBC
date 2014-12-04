package com.tms.corso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AssegnazionePosti {

	protected Set<Studente> studenti;
	protected List<Studente> listaStudenti;
	protected Studente[][] posti;
	private Random destino;
	

	public AssegnazionePosti() throws DataSourceException {
		destino = new Random();
		posti = new Studente[3][6];
		this.studenti = new HashSet<Studente>();
		
		
	}

	public void caricaStudenti() throws DataSourceException {
		Calendar c = Calendar.getInstance();
		c.set(1986, 3, 19);
		Date d1 = c.getTime();
		c.set(1986, 1, 13);
		Date d2 = c.getTime();
		addStudent("Luca", "Amadio", d1, "java", "Matematica", 9);
		addStudent("Manuel", "Scinta", d2, "java", "Fisica", 9);
		addStudent("Teresa", "Morini", d1, "java", "Fisica", 9);
		addStudent("Valentina", "Venturini", d1, "java", "Ingegneria", 9);
		addStudent("Francesco", "Giangaspero", d1, "java", "Matematica", 9);
		addStudent("Michele", "Minchio", d1, "java", "Fisica", 9);
		addStudent("Sandro", "Zaninello", d2, "java", "Web", 9);
		addStudent("Rossella", "Luongo", d1, "java", "Ingegneria", 9);
		addStudent("Sophie", "Molinengo", d1, "java", "Fisica", 9);
		addStudent("Luca", "De Stefano", d2, "java", "Matematica", 9);
		addStudent("Maria", "Petrillo", d1, "java", "Ingegneria", 9);
		addStudent("Leonardo", "Benvenuto", d2, "java", "Ingegneria", 9);
		addStudent("Francesco", "Biglieri", d1, "java", "Fisica", 9);
		addStudent("Manuela", "Messina", d2, "java", "Ingegneria", 9);
		addStudent("Nicola", "Punzi", d1, "java", "Ingegneria", 9);
		addStudent("Alessandro", "De Benedictis", d2, "java", "Ingegneria", 9);
		listaStudenti = new ArrayList<Studente>(studenti);
	}

	public void assegnaPosti() {
		for (int i = 0; i < posti.length; i++) {
			for (int j = 0; j < posti[0].length; j++) {
				if (listaStudenti.isEmpty()) {
					return;
				}
				// if (!(i==1 && (j==0 || j==1))){
				if (i != 1 || j > 1) {
					int pos = destino.nextInt(listaStudenti.size());
					Studente daAssegnare = listaStudenti.remove(pos);
					posti[i][j] = daAssegnare;
				}
			}
		}

	}

	public void mostraAssegnazioni() {
		for (int i = 0; i < posti.length; i++) {
			for (int j = 0; j < posti[0].length; j++) {
				System.out.print(posti[i][j]
						+ (j < posti[0].length - 1 ? "   " : ""));
			}
			System.out.println();
		}
	}

	private void addStudent(String nome, String cognome, Date dataNascita,
			String linguaggio, String titoloStudio, double media) {
		    studenti.add(new Studente(nome, cognome, dataNascita, linguaggio,
				titoloStudio, media));
	}

	public static void main(String[] args) {
		AssegnazionePosti assegnazione=null;
		try {
			assegnazione = new AssegnazionePosti();
			assegnazione.caricaStudenti();
			assegnazione.assegnaPosti();
			assegnazione.mostraAssegnazioni();
		} catch (DataSourceException e) {
			e.printStackTrace();
			System.out.println("gentile utente.." + e.getMessage());
		}
	
	}

}
