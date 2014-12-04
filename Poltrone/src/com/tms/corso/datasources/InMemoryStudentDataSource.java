package com.tms.corso.datasources;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.tms.corso.Studente;

public class InMemoryStudentDataSource implements DataSource<Studente>{

	private Set<Studente> studenti = new HashSet<Studente>();
	
	@Override
	public Set<Studente> load() {
		studenti.clear();
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
		return studenti;
	}

	@Override
	public void save(Set<Studente> toSave) {	
	}

	private void addStudent(String nome, String cognome, Date dataNascita,
			String linguaggio, String titoloStudio, double media) {
		    studenti.add(new Studente(nome, cognome, dataNascita, linguaggio,
				titoloStudio, media));
	}
}
