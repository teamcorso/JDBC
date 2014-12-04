package com.tms.corso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.tms.corso.datasources.DataSource;

public class Assegnazione {

	private DataSource source;
	protected Set<Studente> studenti;
	protected Studente[][] posti;
	private Random destino;

	public Assegnazione(DataSource source) {
		this.source = source;
		this.destino = new Random();
		this.posti = new Studente[3][6];
	}

	public void caricaElementi() throws DataSourceException {
		this.studenti = source.load();
		List<Studente> listaStudenti = new ArrayList<Studente>(studenti);
		assegnaPosti(listaStudenti);
	}

	private void assegnaPosti(List<Studente> listaStudenti) {
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

	public void stampaAssegnazioniInConsole() {
		for (int i = 0; i < posti.length; i++) {
			for (int j = 0; j < posti[0].length; j++) {
				System.out.printf("%-30s", posti[i][j]);
			}
			System.out.println();
		}

	}

}
