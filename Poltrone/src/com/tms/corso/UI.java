package com.tms.corso;

import java.util.Scanner;

import com.tms.corso.datasources.*;


public class UI {

	public static void main(String[] args) {
		
		System.out.println("Vuoi lavorare con:");
		System.out.println("m) dati in memoria");
		System.out.println("t) dati su file di testo");
		System.out.println("s) dati su file serializzato");
		System.out.print("->");
		Scanner s = new Scanner(System.in);
		String answer = s.nextLine();
		DataSource ds;
		
		switch (answer) {
		case "m":
			ds = new InMemoryStudentDataSource();
			break;
		case "t":
			ds = new TextFileStudentDataSource("dati.txt", "ciccio.txt");
		    break;
		case "s":
			ds = new SerializedDataSource<Studente>("dati.ser", "ciccio.ser");
		    break;
		default:
			System.out.println("huh?");
			System.out.println("non ho capito la tua risposta, uso dati in memoria...");
			ds = new InMemoryStudentDataSource();
			break;
		}
		 Assegnazione a = new Assegnazione(ds);
		// Assegnazione a = new Assegnazione(new InMemoryStudentDataSource());
		//Assegnazione a = new Assegnazione(new TextFileStudentDataSource("dati.txt", "ciccio.txt"));
		//Assegnazione a = new Assegnazione(new SerializedDataSource<Studente>("dati.bin", "ciccio.bin"));
		try {
			a.caricaElementi();
			a.stampaAssegnazioniInConsole();
		} catch (DataSourceException e) {
			e.printStackTrace();
		}
	

	}

}
