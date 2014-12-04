package com.tms.corso.datasources;

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
import java.util.HashSet;
import java.util.Set;

import com.tms.corso.DataSourceException;
import com.tms.corso.Studente;


public class TextFileStudentDataSource implements DataSource<Studente> {
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private String filename;
	private String backupFilename;
	private Set<Studente> studenti = new HashSet<Studente>();
	public TextFileStudentDataSource(String filename, String backupFilename) {
		this.filename = filename;
		this.backupFilename = backupFilename;
	}

	@Override
	public Set<Studente> load() throws DataSourceException {
        studenti.clear();
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
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
			return studenti;

		} catch (IOException e) {
			DataSourceException stde = new DataSourceException(
					e.getMessage(), e);
			throw stde;
		}
		
	}

	@Override
	public void save(Set<Studente> toSave) throws DataSourceException {
		try (PrintWriter pw = new PrintWriter(backupFilename)) {
			for (Studente s : studenti)
				pw.println(s.toFileLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new DataSourceException(e.getMessage(), e);

		}

		
	}

}
