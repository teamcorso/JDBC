package com.tms.corso;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudenteTest {
	private Studente stud1;
	private Studente stud2;
	private Studente stud3;
	private Set<Studente> studenti;
	@Before
	public void setUp() throws Exception {
		stud1=new Studente("pippo", "paperis", new Date() , "java", "media", 9);
		stud2=new Studente("pippo", "paperis", null , "cobol", "elementari", 8);
		stud3=new Studente("paperis", "paperis", new Date() , "java", "media", 9);
		studenti=new HashSet<Studente>();
		studenti.add(stud1);
		studenti.add(stud2);
		studenti.add(stud3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEqualsObject() {
		assertTrue(stud1.equals(stud2));
		assertFalse(stud1.equals(stud3));
		assertFalse(stud2.equals(stud3));
		assertEquals(2, studenti.size());
	}

}
