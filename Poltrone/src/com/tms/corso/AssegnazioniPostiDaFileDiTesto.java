package com.tms.corso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class AssegnazioniPostiDaFileDiTesto extends AssegnazionePosti {
	
	String filename;
	
	public AssegnazioniPostiDaFileDiTesto(String filename) throws DataSourceException {
		super();
		this.filename = filename;
	}

	@Override
	public void caricaStudenti() throws DataSourceException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = br.readLine()) != null) {
				// nome=cognome=data=linguaggio=titoloStudio=media
				String[] tokens = line.split("=");
				Date dataNascita;
				try {
					dataNascita = df.parse(tokens[2]);
				} catch (ParseException e) {
					Calendar c = Calendar.getInstance();
					c.set(0, 0, 1);
					dataNascita = c.getTime();
					e.printStackTrace();
				}
				double media = Double.parseDouble(tokens[5]);
				Studente st = new Studente(tokens[0], tokens[1], dataNascita,
						tokens[3], tokens[4], media);
				studenti.add(st);

			}
			listaStudenti = new ArrayList<Studente>(studenti);

		} catch (IOException e) {
			DataSourceException stde = new DataSourceException(
					e.getMessage(), e);
			throw stde;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void mostraAssegnazioni() {
		for (int i = 0; i < posti.length; i++) {
			for (int j = 0; j < posti[0].length; j++) {
				System.out.printf("%-30s", posti[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		AssegnazioniPostiDaFileDiTesto x = null;
		try {
			x = new AssegnazioniPostiDaFileDiTesto("dati.txt");
			x.caricaStudenti();
			x.assegnaPosti();
			x.mostraAssegnazioni();
			x.creaBackup("ciccio.txt");
		} catch (DataSourceException e) {
			System.out.println("gentile utente.." + e.getMessage());
			if (e.getCause() instanceof FileNotFoundException) {
				System.out
						.print("non siamo riusciti a trovare il file dove risiedono i dati, vuoi provare il file di backup? (s/n)->");
				Scanner s = new Scanner(System.in);
				String answer = s.nextLine();
				if (answer.equalsIgnoreCase("s")) {
					try {
						x = new AssegnazioniPostiDaFileDiTesto("ciccio.txt");
						x.caricaStudenti();
						x.assegnaPosti();
						x.mostraAssegnazioni();
						x.creaBackup("ciccio.txt");
					} catch (DataSourceException e1) {
						System.out
								.println("fallimento nell' utilizzo del backup: "
										+ e1.getMessage());
					}
				}
			}
		}

	}

	private void creaBackup(String filename) throws DataSourceException {

		try (PrintWriter pw = new PrintWriter(filename)) {
			for (Studente s : studenti)
				pw.println(s.toFileLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new DataSourceException(e.getMessage(), e);

		}

	}

}
